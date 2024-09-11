package com.highway.tunnelMonitoring.domain.power.frplg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrplgSttus {
    private String frplg_id; //pk
    private String link_id; //fk
    private boolean frplg_alarm;//소화전 발신기 경보
    private boolean frplg_lifted;//소화기 들림
    private boolean frplg_door_open;// 소화전 문 열림
    private boolean atmc_fire_detct; // 화재 탐지 여부
}
