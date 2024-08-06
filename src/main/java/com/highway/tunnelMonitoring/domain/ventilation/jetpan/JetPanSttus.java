package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 제트팬 현황
 */
public class JetPanSttus {
    private String jet_pan_no;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private String change_dt;//변경 일시
    private boolean opr_at;//가동여부
    private boolean defect_at;//고장여부
}
