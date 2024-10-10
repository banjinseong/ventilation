package com.highway.tunnelMonitoring.domain.power.swtbrd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwtbrdRunHistory {
    private String swtbrd_id; //기본키
    private String link_id;
    private String run_start_datetime;
    private String run_end_datetime;
}
