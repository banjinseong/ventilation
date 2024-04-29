package com.highway.ventilation.domain.jetpan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 제트팬 월(한달) 통계
 */
public class JetPanMtStats {
    private String jet_pan_no;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private String stats_mt;//통계 월
    private int opr_time;//가동 시간
    private int opr_co;// 가동 횟수
    private int defect_time;// 고장 시간
    private int deffect_co;// 고장 횟수
}
