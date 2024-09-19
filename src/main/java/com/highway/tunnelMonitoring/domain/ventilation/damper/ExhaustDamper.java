package com.highway.tunnelMonitoring.domain.ventilation.damper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExhaustDamper {
    private String damper_id;
    private String link_id;
    private String instl_lc; // 설치위치
    private LocalDate instl_de; // 설치일자
    private String model_nm;
}
