package com.highway.tunnelMonitoring.service.modbus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 터널들 정보 수집 주기
 */
@Service
@RequiredArgsConstructor
public class AAScheduler {

    private final Eunsan1Tunnel eunsan1Tunnel;

    /**
     * 은산 1터널 데이터 처리
     */
//    @Scheduled(fixedRate = 60000)
    public void eunsan1TunnelData() {
        eunsan1Tunnel.connect();
        eunsan1Tunnel.readData();
        eunsan1Tunnel.disconnect();
    }
}
