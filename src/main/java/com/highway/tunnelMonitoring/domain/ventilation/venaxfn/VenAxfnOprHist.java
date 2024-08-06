package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 축류팬 가동 이력
 */
public class VenAxfnOprHist {
    private String link_id;//링크키(fk)
    private String ven_axfn_no;//축류팬 번호(fk)
    private String opr_begin_dt;//가동 시작일시(pk)
    private String opr_stop_dt;//가동 정지 일시
}
