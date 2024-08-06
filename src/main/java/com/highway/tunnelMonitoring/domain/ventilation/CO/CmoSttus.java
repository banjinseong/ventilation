package com.highway.tunnelMonitoring.domain.ventilation.CO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 일산화탄소 현황
 */
public class CmoSttus {
    private String cmo_msrins_no;// 일산화탄소 계측기 번호(fk)
    private String link_id;//리크키(fk)
    private String change_dt;// 변경일시
    private int cmo_qy;// 일산화탄소 양
    private boolean badn_at;// 불량 여부
}
