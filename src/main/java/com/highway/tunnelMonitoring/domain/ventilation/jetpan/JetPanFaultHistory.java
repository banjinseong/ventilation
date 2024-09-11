package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JetPanFaultHistory {
    private String jet_pan_id;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private String fault_start_datetime; //고장 시작시간
    private String fault_end_datetime; //고장 해결 시간
}
