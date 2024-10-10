package com.highway.tunnelMonitoring.domain.power.ups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ups {
    private String ups_id; // UPS 번호 (Primary Key)
    private String link_id;
    private String instl_lc; // 설치 위치
    private LocalDate instl_de; // 설치 날짜
    private String model_nm;
    private double x_crdnt; //x 좌표
    private double y_crdnt; //y 좌표
}
