package com.highway.tunnelMonitoring.domain.ventilation.pump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PumpStat {
    private String pump_id;
    private String link_id;
    private String recore_date; //기록일(통계일)
    private float run_time_hours; //하루 누적 시간
    private int fault_count; //고장횟수
    private int run_count;//가동횟수
}
