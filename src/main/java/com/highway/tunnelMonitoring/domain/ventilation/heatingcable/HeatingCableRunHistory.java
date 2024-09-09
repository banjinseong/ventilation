package com.highway.tunnelMonitoring.domain.ventilation.heatingcable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeatingCableRunHistory {
    private String cable_id;
    private String link_id;
    private String run_start_datetime;
    private String run_end_datetime;
}
