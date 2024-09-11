package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenAxFnRunHistory {
    private String ven_axfn_id; //기본키
    private String link_id; //링크(fk)키
    private String run_start_datetime;
    private String run_end_datetime;
}
