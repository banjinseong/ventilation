//package com.highway.tunnelMonitoring.service;
//
//import com.fazecast.jSerialComm.SerialPort;
//import net.wimpi.modbus.Modbus;
//import net.wimpi.modbus.io.ModbusRTUTransport;
//import net.wimpi.modbus.msg.ModbusRequest;
//import net.wimpi.modbus.msg.ModbusResponse;
//import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
//import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
//import net.wimpi.modbus.msg.WriteMultipleRegistersRequest;
//import net.wimpi.modbus.net.SerialConnection;
//import net.wimpi.modbus.procimg.Register;
//import net.wimpi.modbus.procimg.SimpleRegister;
//import net.wimpi.modbus.util.SerialParameters;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ModbusRTUService {
//    private SerialConnection serialConnection;
//
//    // 서비스 생성자, 시리얼 연결을 초기화합니다.
//    public ModbusRTUService() {
//        initializeSerialConnection();
//    }
//
//    // 시리얼 연결을 초기화합니다.
//    private void initializeSerialConnection() {
//        try {
//            SerialParameters params = new SerialParameters();
//            params.setPortName("COM1"); // 시리얼 포트 이름 설정
//            params.setBaudRate(9600); // 통신 속도 설정
//            params.setDatabits(8); // 데이터 비트 설정
//            params.setParity(SerialPort.NO_PARITY); // 패리티 설정
//            params.setStopbits(1); // 스톱 비트 설정
//            params.setEncoding(Modbus.SERIAL_ENCODING_RTU); // Modbus RTU 인코딩 설정
//            params.setEcho(false); // 에코 설정
//
//            serialConnection = new SerialConnection(params);
//            serialConnection.open();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Modbus 레지스터를 읽습니다.
//    public int[] readRegisters(int unitId, int ref, int count) {
//        try {
//            // 요청을 생성합니다.
//            ModbusRequest request = new ReadMultipleRegistersRequest(ref, count);
//            request.setUnitID(unitId); // 슬레이브 주소 설정
//            request.setHeadless();
//
//            ModbusRTUTransport transport = (ModbusRTUTransport) serialConnection.getModbusTransport();
//            transport.writeMessage(request); // 요청 메시지를 씁니다.
//
//            // 응답을 기다리는 동안 대기 시간을 추가합니다.
//            Thread.sleep(100); // 100ms 대기 (필요에 따라 조정 가능)
//
//            ModbusResponse response = transport.readResponse(); // 응답을 읽습니다.
//            if (response instanceof ReadMultipleRegistersResponse) {
//                ReadMultipleRegistersResponse readResponse = (ReadMultipleRegistersResponse) response;
//                int[] values = new int[readResponse.getWordCount()];
//                for (int i = 0; i < readResponse.getWordCount(); i++) {
//                    values[i] = readResponse.getRegisterValue(i);
//                }
//                return values;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 예외 발생 시 연결 재설정
//            reconnect();
//        }
//        return null;
//    }
//
//    // Modbus 레지스터에 씁니다.
//    public void writeRegisters(int unitId, int ref, int[] values) {
//        try {
//            // int[] 값을 Register[]로 변환합니다.
//            Register[] registers = new Register[values.length];
//            for (int i = 0; i < values.length; i++) {
//                registers[i] = new SimpleRegister(values[i]);
//            }
//
//            // 요청을 생성합니다.
//            WriteMultipleRegistersRequest request = new WriteMultipleRegistersRequest(ref, registers);
//            request.setUnitID(unitId); // 슬레이브 주소 설정
//            request.setHeadless();
//
//            ModbusRTUTransport transport = (ModbusRTUTransport) serialConnection.getModbusTransport();
//            transport.writeMessage(request); // 요청 메시지를 씁니다.
//
//            // 응답을 기다리는 동안 대기 시간을 추가합니다.
//            Thread.sleep(100); // 100ms 대기 (필요에 따라 조정 가능)
//
//            transport.readResponse(); // Optional: 읽어와서 응답 확인
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 예외 발생 시 연결 재설정
//            reconnect();
//        }
//    }
//
//    // 시리얼 연결을 닫습니다.
//    public void closeConnection() {
//        if (serialConnection != null && serialConnection.isOpen()) {
//            serialConnection.close();
//        }
//    }
//
//    // 연결을 재설정하는 메소드
//    private void reconnect() {
//        try {
//            closeConnection();
//            initializeSerialConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 연결 상태를 확인하는 메소드
//    public boolean isConnectionOpen() {
//        return serialConnection != null && serialConnection.isOpen();
//    }
//
//    // 주기적으로 연결 상태를 확인하고 재연결을 시도하는 스케줄러 메소드
//    @Scheduled(fixedDelay = 5000) // 5초마다 실행
//    public void checkConnectionAndReconnect() {
//        if (!isConnectionOpen()) {
//            reconnect();
//        }
//    }
//}
