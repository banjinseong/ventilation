package com.highway.tunnelMonitoring.domain.ventilation.refgepou;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 피난 갱문 현황
 */
public class RefgePouSttus {
    private String pou_no;//갱문 번호(fk)
    private String link_id;//링크키(fk)
    private String change_dt;//변경 일시
    private boolean opnn_at;//열림 여부
}
