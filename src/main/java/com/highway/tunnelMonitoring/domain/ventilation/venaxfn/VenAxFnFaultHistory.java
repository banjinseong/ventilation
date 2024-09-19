package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenAxFnFaultHistory {
    private String ven_ax_fn_id; //기본키
    private String link_id; //링크(fk)키
    private LocalDateTime fault_start_datetime; //고장 시작시간
    private LocalDateTime fault_end_datetime; //고장 해결 시간
}
