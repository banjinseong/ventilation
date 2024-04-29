package com.highway.ventilation.domain.CO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 일산화탄소 10분 통계
 */
public class Cmo10PartStats {
    private String cmo_msrins_no;//일산화탄소 계측기 번호(fk)
    private String link_id;//링크키(fk)
    private String stats_dt;//통계 일시(pk)
    private int avrg_value;//평균값
    private int mumm_value;//최소값
    private int mxmm_value;//최대값
}
