package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 통계
 */
public class VenAxFnStat {
    private String ven_ax_fn_id; //기본키
    private String link_id; //링크(fk)키
    private LocalDate record_date; //기록일(통계일)
    private float run_time_hours; //하루 누적 시간
    private int fault_count; //고장횟수
    private int run_count;//가동횟수
}
