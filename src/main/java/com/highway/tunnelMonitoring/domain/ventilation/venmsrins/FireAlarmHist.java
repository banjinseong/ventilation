package com.highway.tunnelMonitoring.domain.ventilation.venmsrins;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 화재 경보 이력
 */
public class FireAlarmHist {
    private String fire_alarm_occrrnc_dt;//경보 발생 일시(pk)
    private String link_id;//링크키(fk)
    private String ven_vs_msrins_no;//계측기 번호(fk)
    private String fire_alarm_relis_dt;//화재 경보 해제 일시
    private int occrrnc_meau_value;//발생 계측값
    private int relis_meau_value;//해제 계측값

}


