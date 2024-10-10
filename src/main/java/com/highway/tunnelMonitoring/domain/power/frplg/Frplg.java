package com.highway.tunnelMonitoring.domain.power.frplg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 소방
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Frplg {
    private String frplg_id; //기본키
    private String link_id;
    private String instl_lc; //설치위치
    private LocalDate instl_de;
    private String model_nm;
    private double x_crdnt; //x 좌표
    private double y_crdnt; //y 좌표
}
