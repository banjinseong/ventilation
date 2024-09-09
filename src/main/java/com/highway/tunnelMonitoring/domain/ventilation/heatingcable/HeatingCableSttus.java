package com.highway.tunnelMonitoring.domain.ventilation.heatingcable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeatingCableSttus {
    private String cable_id;
    private String link_id;
    private boolean run_sttus;
    private boolean alarm_sttus;
    private boolean high_temp_alarm;
    private boolean low_temp_alarm;

}
