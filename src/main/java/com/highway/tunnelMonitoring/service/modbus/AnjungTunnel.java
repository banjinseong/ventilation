package com.highway.tunnelMonitoring.service.modbus;

import com.ghgande.j2mod.modbus.io.ModbusTCPTransaction;
import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersRequest;
import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersResponse;
import com.ghgande.j2mod.modbus.net.TCPMasterConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * 14공구
 * 안중유지관리사무소
 */

@Component
@RequiredArgsConstructor
public class AnjungTunnel {

    private final AcbMapper acbMapper;


    private String ipAddress = "10.10.20.151";
    private int port = 502; // Modbus TCP 기본 포트
    private TCPMasterConnection connection;



    public void connect() {
        try {
            if (connection == null || !connection.isConnected()) {
                InetAddress address = InetAddress.getByName(ipAddress);
                connection = new TCPMasterConnection(address);
                connection.setPort(port);
                connection.connect(); // 연결 설정
                System.out.println("Connected to " + ipAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 무슨 데이터를 읽을지? 메서드를 늘려가면될듯.
    public void readData() {
        try {
            int startAddress = 0; // 읽기 시작 주소
            int numberOfRegisters = 10; // 읽을 레지스터 수

            // Modbus 요청 생성
            ReadMultipleRegistersRequest request = new ReadMultipleRegistersRequest(startAddress, numberOfRegisters);
            ModbusTCPTransaction transaction = new ModbusTCPTransaction(connection);
            transaction.setRequest(request);
            transaction.execute();

            /**
             * 기존의 현황 데이터 가져오는 코드
             *  AcbSttus acbSttus = acbMapper.acbFindSttus(?);
             */


            /**
             * 가져온 값 기존 현황이랑 비교하는 코드.(response)
             *
             *
             * 비교후 다른값이 존재하면 이력추가+현황 업데이트,
             * 존재하지 않으면 그냥 pass.
             */

            // 응답 처리
            ReadMultipleRegistersResponse response = (ReadMultipleRegistersResponse) transaction.getResponse();

            /**
             * 가져온 값 기존 현황이랑 비교하는 코드.(response)
             *
             *
             * 비교후 다른값이 존재하면 이력추가+현황 업데이트,
             * 존재하지 않으면 그냥 pass.
             */



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 연결을 끊는 메서드
    public void disconnect() {
        if (connection != null && connection.isConnected()) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Connection was not established.");
        }
    }
}
