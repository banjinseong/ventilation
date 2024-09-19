package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JetPanRunHistory {
    private String jet_pan_id;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private LocalDateTime run_start_datetime;
    private LocalDateTime run_end_datetime;
}
