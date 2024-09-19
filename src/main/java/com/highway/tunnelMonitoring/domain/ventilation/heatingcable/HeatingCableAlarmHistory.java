package com.highway.tunnelMonitoring.domain.ventilation.heatingcable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeatingCableAlarmHistory {
    private String cable_id;
    private String link_id;
    private LocalDateTime alarm_datetime; //경보시작시간
    private String alarm_type; //경보 종류
    private LocalDateTime release_datetime;//경보 종료 시간
}
