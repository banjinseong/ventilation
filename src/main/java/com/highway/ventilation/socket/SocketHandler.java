package com.highway.ventilation.socket;

import com.highway.ventilation.dto.CommunicationFrameDTO;
import com.highway.ventilation.service.CommunicationFrameService;
import lombok.RequiredArgsConstructor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

@RequiredArgsConstructor
public class SocketHandler implements Runnable {

    private final Socket socket;
    private final CommunicationFrameService frameService;
    private boolean running = true; // 연결 유지 상태를 나타내는 변수
    private String senderIp; // 송신지 IP 저장 변수

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {
            DataInputStream dataInputStream = new DataInputStream(input);
            DataOutputStream dataOutputStream = new DataOutputStream(output);

            // 클라이언트에게 일정 시간마다 데이터 요청을 보내기 위한 타이머 설정
            Timer timer = new Timer(true);
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        // 프레임 구조로 데이터 요청 메시지 생성
                        byte[] requestFrame = createRequestFrame();
                        dataOutputStream.write(requestFrame);
                    } catch (IOException e) {
                        e.printStackTrace();
                        running = false; // 오류 발생 시 루프 종료
                    }
                }
            }, 0, 10000); // 10초 간격으로 요청 전송

            while (running) { // 연결을 유지하는 동안 반복
                if (dataInputStream.available() > 0) {
                    byte[] buffer = new byte[256]; // 버퍼 크기는 필요에 따라 조정할 수 있습니다.
                    int bytesRead = dataInputStream.read(buffer); // 데이터를 읽습니다.
                    if (bytesRead > 0) {
                        // 데이터를 파싱하여 프레임 객체를 생성합니다.
                        CommunicationFrameDTO frame = parseFrame(buffer);
                        // 송신지 IP 저장
                        if (senderIp == null) {
                            senderIp = frame.getSenderIp();
                        }
                        // 프레임 데이터를 데이터베이스에 저장합니다.
                        frameService.saveFrame(frame);

                        // OPCode에 따라 데이터를 처리하고 응답을 생성합니다.
                        String response = frameService.processOpcode(frame.getOpcode(), new String(frame.getData(), StandardCharsets.UTF_8));
                        // 응답을 클라이언트에 전송합니다.
                        dataOutputStream.write(response.getBytes(StandardCharsets.UTF_8));
                    }
                } else {
                    // 잠시 대기 후 다시 시도합니다.
                    Thread.sleep(100);
                }
            }

            // 타이머 종료
            timer.cancel();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // 소켓을 닫아 리소스를 해제합니다.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 바이트 배열을 파싱하여 CommunicationFrameDTO 객체를 생성하는 메서드입니다.
    private CommunicationFrameDTO parseFrame(byte[] frameData) {
        CommunicationFrameDTO frame = new CommunicationFrameDTO();
        frame.setSenderIp(new String(frameData, 0, 16, StandardCharsets.UTF_8).trim());
        frame.setDestinationIp(new String(frameData, 16, 32, StandardCharsets.UTF_8).trim());
        frame.setOpcode(new String(frameData, 32, 2, StandardCharsets.UTF_8).trim());
        frame.setData(extractData(frameData, 34));
        return frame;
    }

    // 프레임 데이터의 일부를 추출하여 바이트 배열로 반환하는 메서드입니다.
    private byte[] extractData(byte[] frameData, int offset) {
        int dataLength = frameData.length - offset;
        byte[] data = new byte[dataLength];
        System.arraycopy(frameData, offset, data, 0, dataLength);
        return data;
    }

    // 요청 프레임을 생성하는 메서드입니다.
    private byte[] createRequestFrame() {
        byte[] senderIpBytes = senderIp != null ? senderIp.getBytes(StandardCharsets.UTF_8) : new byte[16];
        byte[] destinationIpBytes = "000.000.000.000".getBytes(StandardCharsets.UTF_8); // 예: 목적지 IP
        byte[] controllerKindBytes = "01".getBytes(StandardCharsets.UTF_8);
        byte[] controllerStationNumberBytes = intToBytes(1, 4); // 예: 고유 주소
        byte[] opcodeBytes = "0x20".getBytes(StandardCharsets.UTF_8); // 예: 요청 OPCode
        byte[] dataFieldBytes = "Request Data".getBytes(StandardCharsets.UTF_8); // 예: 데이터 필드
        byte[] totalLengthBytes = intToBytes(opcodeBytes.length + dataFieldBytes.length, 4);

        byte[] frame = new byte[16 + 16 + 2 + 4 + 4 + 1 + dataFieldBytes.length];
        System.arraycopy(senderIpBytes, 0, frame, 0, senderIpBytes.length);
        System.arraycopy(destinationIpBytes, 0, frame, 16, destinationIpBytes.length);
        System.arraycopy(controllerKindBytes, 0, frame, 32, controllerKindBytes.length);
        System.arraycopy(controllerStationNumberBytes, 0, frame, 34, controllerStationNumberBytes.length);
        System.arraycopy(totalLengthBytes, 0, frame, 38, totalLengthBytes.length);
        System.arraycopy(opcodeBytes, 0, frame, 42, opcodeBytes.length);
        System.arraycopy(dataFieldBytes, 0, frame, 43, dataFieldBytes.length);

        return frame;
    }

    // 정수를 바이트 배열로 변환하는 메서드입니다.
    private byte[] intToBytes(int value, int byteSize) {
        byte[] bytes = new byte[byteSize];
        for (int i = 0; i < byteSize; i++) {
            bytes[byteSize - 1 - i] = (byte) (value >> (i * 8));
        }
        return bytes;
    }
}
