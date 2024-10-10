package com.highway.tunnelMonitoring.domain.power.lght;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LghtRunHistory {

    private String lght_id; //기본키
    private String link_id; //링크아이디
    private LocalDateTime run_start_datetime;
    private LocalDateTime run_end_datetime;
}
