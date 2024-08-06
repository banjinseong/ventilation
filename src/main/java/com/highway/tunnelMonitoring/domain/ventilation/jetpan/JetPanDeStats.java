package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 제트팬 일(하루) 통계
 */
public class JetPanDeStats {
    private String jet_pan_no;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private String status_de;//통계 일
    private int opr_time;//가동 시간
    private int opr_co;// 가동 횟수
    private int defect_time;// 고장 시간
    private int deffect_co;// 고장 횟수
}
