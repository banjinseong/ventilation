//package com.highway.tunnelMonitoring.service;
//
//import jakarta.annotation.PostConstruct;
//import net.wimpi.modbus.io.ModbusTCPTransaction;
//import net.wimpi.modbus.msg.ModbusRequest;
//import net.wimpi.modbus.msg.ModbusResponse;
//import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
//import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
//import net.wimpi.modbus.net.TCPMasterConnection;
//import org.springframework.stereotype.Service;
//
//import java.net.InetAddress;
//
//@Service
//public class ModbusRTUService1 {
//
//    private final String ipAddress = "192.168.0.101"; // RTU1의 IP 주소
//    private final int port = 502;
//    private TCPMasterConnection connection;
//    private ModbusTCPTransaction transaction;
//
//    @PostConstruct
//    public void initializeConnection() {
//        connect();
//    }
//
//    private void connect() {
//        try {
//            InetAddress address = InetAddress.getByName(ipAddress);
//            connection = new TCPMasterConnection(address);
//            connection.setPort(port);
//            connection.connect();
//            transaction = new ModbusTCPTransaction(connection);
//            System.out.println("RTU1 연결 성공 (" + ipAddress + ")");
//        } catch (Exception e) {
//            System.err.println("RTU1 연결 실패 (" + ipAddress + "): " + e.getMessage());
//        }
//    }
//
//    public void requestData() {
//        if (isConnected()) {
//            try {
//                // Slot 01: %IX0.0.00 ~ %IX0.0.31 (레지스터 0, 1)
//                int[] dataSlot01 = requestDataFromRtu(0, 2);  // 두 개의 레지스터 (레지스터 주소 0부터)
//                processReceivedData(dataSlot01, 0);  // 비트 주소 0부터 시작
//
//                // Slot 02: %IX0.1.00 ~ %IX0.1.31 (레지스터 2, 3)
//                int[] dataSlot02 = requestDataFromRtu(2, 2);  // 두 개의 레지스터 (레지스터 주소 2부터)
//                processReceivedData(dataSlot02, 32);  // 비트 주소 32부터 시작
//
//                // Slot 05: %QX0.5.00 ~ %QX0.5.31 (레지스터 10, 11)
//                int[] dataSlot05 = requestDataFromRtu(10, 2);  // 두 개의 레지스터 (레지스터 주소 10부터)
//                processReceivedData(dataSlot05, 160);  // 비트 주소 160부터 시작
//
//                // 추가 슬롯에 대해서도 동일한 패턴으로 요청하면 됩니다.
//            } catch (Exception e) {
//                System.err.println("RTU1 데이터 요청 오류 (" + ipAddress + "): " + e.getMessage());
//                reconnect();
//            }
//        } else {
//            reconnect();
//        }
//    }
//
//    public boolean isConnected() {
//        return connection != null && connection.isConnected();
//    }
//
//    public void reconnect() {
//        System.out.println("RTU1 재연결 시도 (" + ipAddress + ")");
//        connect();
//    }
//
//    private int[] requestDataFromRtu(int startRegister, int quantity) throws Exception {
//        // Read multiple registers starting from startRegister
//        ModbusRequest request = new ReadMultipleRegistersRequest(startRegister, quantity);
//        transaction.setRequest(request);
//        transaction.execute();
//        ModbusResponse response = transaction.getResponse();
//
//        if (response instanceof ReadMultipleRegistersResponse) {
//            ReadMultipleRegistersResponse dataResponse = (ReadMultipleRegistersResponse) response;
//            int[] data = new int[quantity];
//            for (int i = 0; i < quantity; i++) {
//                data[i] = dataResponse.getRegisterValue(i);
//            }
//            return data;
//        } else {
//            throw new RuntimeException("Unexpected response type");
//        }
//    }
//
//    private void processReceivedData(int[] data, int startBitAddress) {
//        System.out.println("RTU1에서 받은 데이터 (Bit Address " + startBitAddress + "부터):");
//        for (int i = 0; i < data.length; i++) {
//            // 각 레지스터는 16비트를 포함하므로, 이를 비트 단위로 출력할 수 있습니다.
//            for (int bit = 0; bit < 16; bit++) {
//                int bitValue = (data[i] >> bit) & 1; // 각 비트를 분리
//                System.out.println("Bit Address " + (startBitAddress + i * 16 + bit) + ": " + bitValue);
//            }
//        }
//    }
//}