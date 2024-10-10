package com.highway.tunnelMonitoring.domain.ventilation.watertank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 수조
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterTank {
    private String tank_id;
    private String link_id;
    private String instl_lc; // 설치위치
    private String instl_de; // 설치일자
    private String model_nm;
    private double x_crdnt; //x 좌표
    private double y_crdnt; //y 좌표
}
