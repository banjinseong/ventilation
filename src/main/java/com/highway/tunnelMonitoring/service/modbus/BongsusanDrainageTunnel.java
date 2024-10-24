package com.highway.tunnelMonitoring.service.modbus;


import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanSttus;
import com.highway.tunnelMonitoring.service.ventilation.JetPanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * 8~9공구
 * RTU-M2(제트팬 x32)
 * 급,배기팬(전기실)
 * 배연댐퍼(익산부터 받아와짐.)
 *
 */

@Component
@RequiredArgsConstructor
public class BongsusanDrainageTunnel {


    private String ipAddress = "10.20.12.221";
    private int port = 502; // Modbus TCP 기본 포트
    private final RedisTemplate<String, Object> redisTemplate;
    private final JetPanService jetPanService;



    // 제트팬 통신
    public void readHoldingJetPan(int startAddress, int numberOfRegisters) {

        try (Socket socket = new Socket(InetAddress.getByName(ipAddress), port)) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());

            // Modbus TCP 요청 헤더 (Transaction ID, Protocol ID, Length, Unit ID)
            byte[] modbusRequest = new byte[12];

            // Transaction ID: 0x0001
            modbusRequest[0] = 0x00;
            modbusRequest[1] = 0x01;
            // Protocol ID: 0x0000 (Modbus TCP)
            modbusRequest[2] = 0x00;
            modbusRequest[3] = 0x00;
            // Length: 0x0006 (6바이트 요청)
            modbusRequest[4] = 0x00;
            modbusRequest[5] = 0x06;
            // Unit ID: 0x01 (장치 ID)
            modbusRequest[6] = 0x01;

            // Modbus PDU (Function Code, Start Address, Number of Registers)
            modbusRequest[7] = 0x03; // Function Code: 0x03 (Read Holding Registers)
            // Start Address (2바이트)
            modbusRequest[8] = (byte) ((startAddress >> 8) & 0xFF); // 시작 주소 상위 바이트
            modbusRequest[9] = (byte) (startAddress & 0xFF); // 시작 주소 하위 바이트
            // Number of Registers (2바이트)
            modbusRequest[10] = (byte) ((numberOfRegisters >> 8) & 0xFF); // 레지스터 개수 상위 바이트
            modbusRequest[11] = (byte) (numberOfRegisters & 0xFF); // 레지스터 개수 하위 바이트

            // 요청 패킷 전송
            output.write(modbusRequest);
            output.flush();

            // 응답 읽기
            byte[] modbusResponse = new byte[550]; // 응답을 받을 배열 크기 (최대 550 바이트로 설정) 제트팬 한대당 길이 = 16
            int bytesRead = input.read(modbusResponse);


            /**
             * 제트팬 32개 처리
             * 시작주소 10001~ (8x32 = 256)
             * 109~124 : 16개(9바이트~25
             * 209~224 : 16개
             */
            for (int i = 0; i < 16; i++) {
                String jetPanId = "JF-" + (109 + i);
                JetPanSttus cachedSttus = (JetPanSttus) redisTemplate.opsForValue().get(jetPanId);
                byte diByte = modbusResponse[9 + i * 16];
                boolean new_remote_mode = (diByte & 0b00000001) != 0; // B0
                boolean new_forward_mode = (diByte & 0b00000010) != 0; // B1
                boolean new_reverse_mode = (diByte & 0b00000100) != 0; // B2
                boolean new_fault_sttus = (diByte & 0b00001000) != 0; // B3


                if(cachedSttus == null){
                    cachedSttus.setJet_pan_id(jetPanId);
                    cachedSttus.setLink_id("8tunnel");
                }

                //캐시데이터와 현재데이터값 비교 후 데이터값 변경시 캐시 데이터 갱신
                //캐시데이터의 유효시간은 1시간으로 하고 1시간 뒤에는 자동갱신.
                if(cachedSttus.isRemote_mode() != new_remote_mode ||
                    cachedSttus.isForward_mode() != new_forward_mode ||
                    cachedSttus.isReverse_mode() != new_reverse_mode||
                    cachedSttus.isFault_sttus() != new_fault_sttus)
                {
                    cachedSttus.setRemote_mode(new_remote_mode);
                    cachedSttus.setForward_mode(new_forward_mode);
                    cachedSttus.setReverse_mode(new_reverse_mode);
                    cachedSttus.setFault_sttus(new_fault_sttus);
                    redisTemplate.opsForValue().set(jetPanId, cachedSttus, 1, TimeUnit.HOURS);
                    jetPanService.updateSttus(cachedSttus);
                }

            }


            for (int i = 0; i < 16; i++) {
                String jetPanId = "JF-" + (209 + i);
                JetPanSttus cachedSttus = (JetPanSttus) redisTemplate.opsForValue().get(jetPanId);
                byte diByte = modbusResponse[9 + i * 16];
                boolean new_remote_mode = (diByte & 0b00000001) != 0; // B0
                boolean new_forward_mode = (diByte & 0b00000010) != 0; // B1
                boolean new_reverse_mode = (diByte & 0b00000100) != 0; // B2
                boolean new_fault_sttus = (diByte & 0b00001000) != 0; // B3


                if(cachedSttus == null){
                    cachedSttus.setJet_pan_id(jetPanId);
                    cachedSttus.setLink_id("8tunnel");
                }

                //캐시데이터와 현재데이터값 비교 후 데이터값 변경시 캐시 데이터 갱신
                //캐시데이터의 유효시간은 1시간으로 하고 1시간 뒤에는 자동갱신.
                if(cachedSttus.isRemote_mode() != new_remote_mode ||
                        cachedSttus.isForward_mode() != new_forward_mode ||
                        cachedSttus.isReverse_mode() != new_reverse_mode||
                        cachedSttus.isFault_sttus() != new_fault_sttus)
                {
                    cachedSttus.setRemote_mode(new_remote_mode);
                    cachedSttus.setForward_mode(new_forward_mode);
                    cachedSttus.setReverse_mode(new_reverse_mode);
                    cachedSttus.setFault_sttus(new_fault_sttus);
                    redisTemplate.opsForValue().set(jetPanId, cachedSttus, 1, TimeUnit.HOURS);
                    jetPanService.updateSttus(cachedSttus);
                }

            }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 일간 누적가동시간 int로 가져오는거 있던데 체크 확인 바람.
     */
    // 바이트 배열을 Float로 변환하는 함수
    private float convertToInt(byte[] data, int index) {
        // 4바이트 데이터를 Float로 변환
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.put(data[index]); // 상위 바이트
        buffer.put(data[index + 1]);
        buffer.flip(); // 읽기 모드로 변경
        return buffer.getInt();
    }


}
