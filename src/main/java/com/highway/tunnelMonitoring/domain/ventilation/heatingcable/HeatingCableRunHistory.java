package com.highway.tunnelMonitoring.domain.ventilation.heatingcable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeatingCableRunHistory {
    private String cable_id;
    private String link_id;
    private LocalDateTime run_start_datetime;
    private LocalDateTime run_end_datetime;
}
