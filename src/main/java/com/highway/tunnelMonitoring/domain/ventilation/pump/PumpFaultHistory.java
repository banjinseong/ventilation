package com.highway.tunnelMonitoring.domain.ventilation.pump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PumpFaultHistory {

    private String pump_id;
    private String link_id;
    private LocalDateTime fault_start_datetime; //고장 시작시간
    private LocalDateTime fault_end_datetime; //고장 해결 시간
}
