package com.highway.tunnelMonitoring.domain.ventilation.pump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PumpSttus {

    private String pump_id;
    private String link_id;
    private boolean remote_mode;
    private boolean run_sttus;
    private boolean fault_sttus;
}
