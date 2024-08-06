package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 축류팬 월(한달) 통계
 */
public class VenAxfnMtStats {
    private String link_id;//링크키(fk)
    private String ven_axfn_no;//축류팬 번호(fk)
    private String stats_mt;//통계 일(pk)
    private int opr_time;//가동 시간
    private int opr_co;//가동 횟수
    private int defect_time;//고장시간
    private int defect_co;//고장 횟수
}
