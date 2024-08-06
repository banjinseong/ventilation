package com.highway.tunnelMonitoring.domain.power;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 조명 (Lght)
 */
public class Lght {

    private String lght_group_no; // 조명 그룹 번호 (Primary Key)
    private String lght_knd; // 조명 종류 (Primary Key)
    private String makr_nm; // 제조사 이름
    private String model_nm; // 모델 이름
    private String instl_lc; // 설치 위치
    private String instl_de; // 설치 날짜
    private double instl_milg; // 설치 거리
    private double begin_x_crdnt; // 시작 X 좌표
    private double begin_y_crdnt; // 시작 Y 좌표
    private double end_x_crdnt; // 끝 X 좌표
    private double end_y_crdnt; // 끝 Y 좌표
    private String lmtr_no; // 조도계 번호 (Foreign Key)
}
