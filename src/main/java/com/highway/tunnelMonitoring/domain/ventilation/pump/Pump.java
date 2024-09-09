package com.highway.tunnelMonitoring.domain.ventilation.pump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pump {
    private String pump_id;
    private String link_id;
    private String instl_lc; // 설치위치
    private String instl_de; // 설치일자
    private String model_nm;
}
