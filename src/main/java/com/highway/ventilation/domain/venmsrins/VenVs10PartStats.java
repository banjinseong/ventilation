package com.highway.ventilation.domain.venmsrins;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 가시도 10 분 통계
 */
public class VenVs10PartStats {
    private String link_id;//링크키(fk)
    private String ven_vs_msrins_no;//계측기 번호(fk)
    private String stats_dt;//통계 일시(pk)
    private int avrg_value;//평균값
    private int mumm_value;//최소값
    private int mxmm_value;//최대값
}
