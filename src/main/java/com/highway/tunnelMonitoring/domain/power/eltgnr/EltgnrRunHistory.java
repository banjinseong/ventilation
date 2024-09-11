package com.highway.tunnelMonitoring.domain.power.eltgnr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EltgnrRunHistory {
    private String eltgnr_no; //기본키
    private String link_id;
    private String run_start_datetime;
    private String run_end_datetime;
}
