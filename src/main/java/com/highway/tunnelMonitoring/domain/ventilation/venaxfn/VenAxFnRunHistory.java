package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenAxFnRunHistory {
    private String ven_ax_fn_id; //기본키
    private String link_id; //링크(fk)키
    private LocalDateTime run_start_datetime;
    private LocalDateTime run_end_datetime;
}
