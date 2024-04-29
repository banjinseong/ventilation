package com.highway.ventilation.domain.inshlt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 온도 10분 통계
 */
public class Tp10PartStats {
    private String inshlt_no;//백엽상 번호(fk)
    private String link_id;//링크키(fk)
    private String stats_dt;//통계 일시(pk)
    private int avrg_value;//평균값
    private int mumm_value;//최소값
    private int mxmm_value;//최대값

}
