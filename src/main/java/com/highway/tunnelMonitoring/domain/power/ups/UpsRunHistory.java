package com.highway.tunnelMonitoring.domain.power.ups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsRunHistory {
    private String ups_no;
    private String link_id;
    private String run_start_datetime;
    private String run_end_datetime;
}
