package com.highway.tunnelMonitoring.domain.power.eld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EldAlarmHistroy {
    private String eld_id;
    private String link_id;
    private String alarm_datetime; //경보시작시간
    private String alarm_type; //경보 종류
    private String release_datetime;//경보 종료 시간
}