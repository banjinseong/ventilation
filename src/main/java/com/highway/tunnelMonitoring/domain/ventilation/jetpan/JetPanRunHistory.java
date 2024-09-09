package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JetPanRunHistory {
    private String jet_pan_no;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private String run_start_datetime;
    private String run_end_datetime;
}
