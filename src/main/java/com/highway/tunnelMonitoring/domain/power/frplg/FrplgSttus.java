package com.highway.tunnelMonitoring.domain.power.frplg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrplgSttus {
    private String frplg_no; //pk
    private String link_id; //fk
    private String change_dt; //변경일시
    private char door_opnn_at; //문열림 여부
    private char emgnc_alarm_at; //비상경보여부
    private char extshr_1_scesn_at;//소화기 1 이탈 여부
    private char extshr_2_scesn_at;//소화기 2 이탈 여부
    private char fire_detct_at; // 화재 탐지 여부
}
