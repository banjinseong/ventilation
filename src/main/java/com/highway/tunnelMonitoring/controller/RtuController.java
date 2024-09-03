package com.highway.tunnelMonitoring.controller;


import com.highway.tunnelMonitoring.service.ModbusRTUService1;
import com.highway.tunnelMonitoring.service.RtuService2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class RtuController {

    private final ModbusRTUService1 rtuService1;
    private final RtuService2 rtuService2;

    public RtuController(ModbusRTUService1 rtuService1, RtuService2 rtuService2) {
        this.rtuService1 = rtuService1;
        this.rtuService2 = rtuService2;
    }

    @Scheduled(fixedRate = 5000)  // 5초마다 주기적으로 실행
    public void requestDataFromRtus() {
        checkAndReconnectRtu(rtuService1);
        checkAndReconnectRtu(rtuService2);

        rtuService1.requestData();
        rtuService2.requestData();
    }

    // 연결 상태를 확인하고, 필요시 재연결을 시도하는 메서드
    private void checkAndReconnectRtu(Object rtuService) {
        if (rtuService instanceof ModbusRTUService1) {
            if (!((ModbusRTUService1) rtuService).isConnected()) {
                ((ModbusRTUService1) rtuService).reconnect();
            }
        } else if (rtuService instanceof RtuService2) {
            if (!((RtuService2) rtuService).isConnected()) {
                ((RtuService2) rtuService).reconnect();
            }
        }
    }
}