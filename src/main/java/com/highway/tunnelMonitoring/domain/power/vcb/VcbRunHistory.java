package com.highway.tunnelMonitoring.domain.power.vcb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VcbRunHistory {
    private String vcb_id; //기본키
    private String link_id;
    private String run_start_datetime;
    private String run_end_datetime;
}
