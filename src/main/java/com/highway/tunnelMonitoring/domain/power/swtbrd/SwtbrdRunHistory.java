package com.highway.tunnelMonitoring.domain.power.swtbrd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwtbrdRunHistory {
    private String swtbrd_id; //기본키
    private String link_id;
    private LocalDateTime run_start_datetime;
    private LocalDateTime run_end_datetime;
}
