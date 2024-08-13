package com.highway.tunnelMonitoring.dto.power.trnsfmr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrnsfmrMonitorDTO {
    private String pow_pop_no;// 수배전반 번호
    private String trnsfmr_no;// 변압기 번호
    private String change_dt; // 변경일시
    private double tp; //온도
    private char hhtmp_alarm_at; //고온 경보 여부
}
