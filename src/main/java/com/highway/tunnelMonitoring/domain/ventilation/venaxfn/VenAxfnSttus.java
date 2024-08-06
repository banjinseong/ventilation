package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 축류팬 현황
 */
public class VenAxfnSttus {
    private String link_id;//링크키(fk)
    private String ven_axfn_no;//축류팬 번호(fk)
    private String change_dt;//변경일시
    private boolean opr_at;//가동 여부
    private boolean trobl_at;//장애 여부
}
