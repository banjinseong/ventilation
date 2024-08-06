package com.highway.tunnelMonitoring.domain.power;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 긴급전화
 */
public class EmgncTlphon {

    private String emgnc_tlphon_no; // 긴급 전화 번호 (Primary Key)
    private String link_id; // 링크 ID (Foreign Key)
    private String makr_nm; // 제조사 이름
    private String model_nm; // 모델 이름
    private String instl_lc; // 설치 위치
    private String instl_de; // 설치 날짜
    private double instl_milg; // 설치 거리
    private double x_crdnt; // X 좌표
    private double y_crdnt; // Y 좌표
}
