package com.highway.tunnelMonitoring.dto.ventilation.cmomsrins;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CmoMsrinsMonitorDTO {
    private String cmo_msrins_no; //기본키
    private String link_id;
    private String change_dt;// 변경일시
    private double cmo_qy;// 일산화탄소_량
    private char badn_at;//불량여부
}
