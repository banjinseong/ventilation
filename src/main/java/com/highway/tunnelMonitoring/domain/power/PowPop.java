package com.highway.tunnelMonitoring.domain.power;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 수배전반 (PowPop)
 */
public class PowPop {

    private String pow_pop_no; // 수배전반 번호 (Primary Key)
    private String makr_nm; // 제조사 이름
    private String instl_lc; // 설치 위치
    private String instl_de; // 설치 날짜
    private double x_crdnt; // X 좌표
    private double y_crdnt; // Y 좌표
}
