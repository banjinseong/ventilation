package com.highway.tunnelMonitoring.domain.ventilation.damper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExhaustDamperRunHistory {
    private String damper_id;
    private String link_id;
    private String run_start_datetime;
    private String run_end_datetime;
}