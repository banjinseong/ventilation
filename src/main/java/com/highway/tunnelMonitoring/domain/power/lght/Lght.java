package com.highway.tunnelMonitoring.domain.power.lght;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 조명(디밍제어기)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lght {
    private String lght_id; //기본키
    private String link_id; //링크아이디
    private String instl_lc; //설치위치
    private LocalDate instl_de; //설치일자
    private String model_nm; //모델넘버(이름)
    private double x_crdnt; //x 좌표
    private double y_crdnt; //y 좌표
}
