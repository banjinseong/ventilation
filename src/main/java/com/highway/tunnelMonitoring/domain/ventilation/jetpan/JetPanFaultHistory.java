package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JetPanFaultHistory {
    private String jet_pan_id;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private LocalDateTime fault_start_datetime; //고장 시작시간
    private LocalDateTime fault_end_datetime; //고장 해결 시간
}
