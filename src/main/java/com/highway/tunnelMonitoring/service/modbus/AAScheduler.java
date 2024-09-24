package com.highway.tunnelMonitoring.service.modbus;

import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersResponse;
import com.highway.tunnelMonitoring.domain.power.acb.AcbSttus;
import com.highway.tunnelMonitoring.mapper.power.AcbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


/**
 * 터널들 정보 수집 주기
 */
@Service
@RequiredArgsConstructor
public class AAScheduler {

    private final Eunsan1Tunnel eunsan1Tunnel = new Eunsan1Tunnel();
    private final AcbMapper acbMapper;

    /**
     * 은산 1터널 데이터 처리
     */
    @Scheduled(fixedRate = 60000)
    public void eunsan1TunnelData() {

        eunsan1Tunnel.connect();

        ReadMultipleRegistersResponse response = eunsan1Tunnel.readData();
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

        eunsan1Tunnel.disconnect();
    }
}
