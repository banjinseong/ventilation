package com.highway.tunnelMonitoring.domain.ventilation.fire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FireStat {

    private String link_id;
    private LocalDate record_date; //기록일(통계일)
    private int fire_count; //화재 발생량
}
