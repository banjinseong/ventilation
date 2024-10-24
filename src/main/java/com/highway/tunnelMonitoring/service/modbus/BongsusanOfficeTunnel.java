package com.highway.tunnelMonitoring.service.modbus;

import com.ghgande.j2mod.modbus.io.ModbusTCPTransaction;
import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersRequest;
import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersResponse;
import com.ghgande.j2mod.modbus.net.TCPMasterConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * 8공구
 * 봉수산 관리사무소
 */

@Component
@RequiredArgsConstructor
public class BongsusanOfficeTunnel {



    private String ipAddress = "10.20.12.201";

    private int port = 502; // Modbus TCP 기본 포트

    // 각 변수에 값을 저장하기 위한 필드
    private int rectifierLowVoltageAlarm;
    private int acVoltage;
    private int dcVoltage;
    private int dcCurrent1;
    private int dcCurrent2;

    // Modbus TCP 패킷 생성 및 송신
    public void readHoldingRegisters(int startAddress, int numberOfRegisters) {
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
            byte[] modbusResponse = new byte[256]; // 응답을 받을 배열 크기 (최대 256 바이트로 설정)
            int bytesRead = input.read(modbusResponse);

            // 응답 데이터 처리 (16진수로 출력)
            System.out.println("Received " + bytesRead + " bytes from the Modbus server");
            for (int i = 0; i < bytesRead; i++) {
                System.out.printf("%02X ", modbusResponse[i]);
            }
            System.out.println();

            // Modbus 응답 데이터 해석 (레지스터 값들을 저장)
            rectifierLowVoltageAlarm = modbusResponse[9] << 8 | modbusResponse[10]; // 레지스터 419471
            acVoltage = modbusResponse[11] << 8 | modbusResponse[12];              // 레지스터 419472
            dcVoltage = modbusResponse[13] << 8 | modbusResponse[14];              // 레지스터 419473
            dcCurrent1 = modbusResponse[15] << 8 | modbusResponse[16];             // 레지스터 419474
            dcCurrent2 = modbusResponse[17] << 8 | modbusResponse[18];             // 레지스터 419475


            // 읽은 값 출력
            System.out.println("Rectifier Low Voltage Alarm: " + rectifierLowVoltageAlarm);
            System.out.println("AC Voltage: " + acVoltage);
            System.out.println("DC Voltage: " + dcVoltage);
            System.out.println("DC Current 1: " + dcCurrent1);
            System.out.println("DC Current 2: " + dcCurrent2);
//                       rsVoltage = convertToFloat(modbusResponse, 9);
//            stVoltage = convertToFloat(modbusResponse, 13);
//            trVoltage = convertToFloat(modbusResponse, 17);
//            rCurrent = convertToFloat(modbusResponse, 21);
//            sCurrent = convertToFloat(modbusResponse, 25);
//            tCurrent = convertToFloat(modbusResponse, 29);
//            power = convertToFloat(modbusResponse, 33);
//            energy = convertToFloat(modbusResponse, 37);
//            powerFactor = convertToFloat(modbusResponse, 41);
//            frequency = convertToFloat(modbusResponse, 45);
//
//            // 읽은 값 출력
//            System.out.println("R-S Voltage: " + rsVoltage);
//            System.out.println("S-T Voltage: " + stVoltage);
//            System.out.println("T-R Voltage: " + trVoltage);
//            System.out.println("R Current: " + rCurrent);
//            System.out.println("S Current: " + sCurrent);
//            System.out.println("T Current: " + tCurrent);
//            System.out.println("Power: " + power);
//            System.out.println("Energy: " + energy);
//            System.out.println("Power Factor: " + powerFactor);
//            System.out.println("Frequency: " + frequency);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 바이트 배열을 Float로 변환하는 함수
//    private float convertToFloat(byte[] data, int index) {
//        // 4바이트 데이터를 Float로 변환
//        ByteBuffer buffer = ByteBuffer.allocate(4);
//        buffer.put(data[index]); // 상위 바이트
//        buffer.put(data[index + 1]);
//        buffer.put(data[index + 2]);
//        buffer.put(data[index + 3]); // 하위 바이트
//        buffer.flip(); // 읽기 모드로 변경
//        return buffer.getFloat();
//    }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
