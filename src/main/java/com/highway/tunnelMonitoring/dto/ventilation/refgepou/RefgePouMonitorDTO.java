package com.highway.tunnelMonitoring.dto.ventilation.refgepou;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefgePouMonitorDTO {
    private String pou_no;//갱문 번호(fk)
    private String link_id;//링크키(fk)
    private String change_dt;//변경 일시
    private boolean opnn_at;//열림 여부
}
