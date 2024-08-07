package com.highway.tunnelMonitoring.domain.power;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * UPS (Uninterruptible Power Supply)
 */
public class Ups {

    private String ups_no; // UPS 번호 (Primary Key)
    private String makr_nm; // 제조사 이름
    private String model_nm; // 모델 이름
    private String instl_lc; // 설치 위치
    private String instl_de; // 설치 날짜
    private int pero; // PERO 값
    private double x_crdnt; // X 좌표
    private double y_crdnt; // Y 좌표
}


