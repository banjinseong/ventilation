package com.highway.tunnelMonitoring.dto.ventilation.jetpan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JetPanMonitorDTO {
    private String jet_pan_no;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private String change_dt;//변경 일시
    private char opr_at;//가동여부
    private char defect_at;//고장여부
}
