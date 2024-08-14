package com.highway.tunnelMonitoring.domain.power.eltgnr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EltgnrSttus {
    private String eltgnr_no; //기본키
    private String change_dt; //변경일시
    private int crcbrk_sttus; //차단기상태
    private char kwa_ercrt_alarm_at; //과 전류 경보 여부
    private char kwa_ercrt_grnd_alarm_at; //과 전류 지락 경보 여부
    private char kwa_vltge_cours_at; //과 전압 경로 여부
    private char low_vltge_alarm_at; //저 전압 경보 여부
    private char kwa_vltge_grnd_alarm_at; //과 전압 지락 경보 여부
    private char oph_alarm_at; //결상 경보 여부
    private double valid_pwrer;//유효 전력
    private double valid_pwrer_qy; //유효 전력 량
    private double pf; //역률
}
