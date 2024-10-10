package com.highway.tunnelMonitoring.domain.ventilation.heatingcable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 히팅케이블
 */
public class HeatingCable {
    private String cable_id;
    private String link_id;
    private String instl_lc;
    private LocalDate instl_de;
    private String model_nm;
    private double x_crdnt; //x 좌표
    private double y_crdnt; //y 좌표
}
