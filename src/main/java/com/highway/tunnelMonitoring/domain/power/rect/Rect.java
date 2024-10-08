package com.highway.tunnelMonitoring.domain.power.rect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 정류기
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rect {
    private String rect_id; // 정류기 번호 (Primary Key)
    private String link_id;
    private String instl_lc; // 설치 위치
    private LocalDate instl_de; // 설치 날짜
    private String model_nm;
    private double x_crdnt; //x 좌표
    private double y_crdnt; //y 좌표
}
