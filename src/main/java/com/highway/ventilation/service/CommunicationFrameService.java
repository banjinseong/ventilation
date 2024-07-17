package com.highway.ventilation.service;

import com.highway.ventilation.dto.CommunicationFrameDTO;
import com.highway.ventilation.mapper.CommunicationFrameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunicationFrameService {
    @Autowired
    private CommunicationFrameMapper mapper;

    public void saveFrame(CommunicationFrameDTO frame) {
        mapper.insertCommunicationFrame(frame);
    }

    public String processOpcode(String opcode, String data) {
        // OPCode에 따른 데이터 처리 로직
        switch (opcode) {
            case "0xFF":
                return handleDeviceIdRequest(data);
            case "0x20":
                return handleDataReception(data);
            case "0x21":
                return handleStatusRequest(data);
            case "0x22":
                return handleSensorCheck(data);
            case "0x23":
                return handleEmergencyRequest(data);
            default:
                return "Unknown OPCode";
        }
    }

    private String handleDeviceIdRequest(String data) {
        // 장비 ID 요청 처리 로직
        return "Device ID Response";
    }

    private String handleDataReception(String data) {
        // 데이터 수신 처리 로직
        return "Data Received";
    }

    private String handleStatusRequest(String data) {
        // 상태 정보 요청 처리 로직
        return "Status Information";
    }

    private String handleSensorCheck(String data) {
        // 통신 센서 유효성 확인 처리 로직
        return "Sensor Check Response";
    }

    private String handleEmergencyRequest(String data) {
        // 원격 긴급 전화 요청 처리 로직
        return "Emergency Request Response";
    }
}
