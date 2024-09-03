package com.highway.tunnelMonitoring.service;

import jakarta.annotation.PostConstruct;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ModbusRequest;
import net.wimpi.modbus.msg.ModbusResponse;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.net.TCPMasterConnection;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

@Service
public class RtuService2 {

    private final String ipAddress = "192.168.0.102"; // RTU2의 IP 주소
    private final int port = 502;
    private TCPMasterConnection connection;
    private ModbusTCPTransaction transaction;

    @PostConstruct
    public void initializeConnection() {
        connect();
    }

    private void connect() {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            connection = new TCPMasterConnection(address);
            connection.setPort(port);
            connection.connect();
            transaction = new ModbusTCPTransaction(connection);
            System.out.println("RTU2 연결 성공 (" + ipAddress + ")");
        } catch (Exception e) {
            System.err.println("RTU2 연결 실패 (" + ipAddress + "): " + e.getMessage());
        }
    }

    public void requestData() {
        if (isConnected()) {
            try {
                int[] data = requestDataFromRtu();
                processReceivedData(data);
            } catch (Exception e) {
                System.err.println("RTU2 데이터 요청 오류 (" + ipAddress + "): " + e.getMessage());
                reconnect();
            }
        } else {
            reconnect();
        }
    }

    public boolean isConnected() {
        return connection != null && connection.isConnected();
    }

    public void reconnect() {
        System.out.println("RTU2 재연결 시도 (" + ipAddress + ")");
        connect();
    }

    private int[] requestDataFromRtu() throws Exception {
        ModbusRequest request = new ReadMultipleRegistersRequest(20, 5);
        transaction.setRequest(request);
        transaction.execute();
        ModbusResponse response = transaction.getResponse();

        if (response instanceof ReadMultipleRegistersResponse) {
            ReadMultipleRegistersResponse dataResponse = (ReadMultipleRegistersResponse) response;
            int[] data = new int[dataResponse.getWordCount()];
            for (int i = 0; i < dataResponse.getWordCount(); i++) {
                data[i] = dataResponse.getRegisterValue(i);
            }
            return data;
        } else {
            throw new RuntimeException("Unexpected response type");
        }
    }

    private void processReceivedData(int[] data) {
        // 데이터를 처리하는 로직을 여기에 추가할 수 있습니다.
        System.out.println("RTU2에서 받은 데이터: " + arrayToString(data));
    }

    private String arrayToString(int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int value : data) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }
}
