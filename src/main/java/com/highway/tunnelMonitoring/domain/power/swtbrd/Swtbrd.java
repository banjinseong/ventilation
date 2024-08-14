package com.highway.tunnelMonitoring.domain.power.swtbrd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Swtbrd {
    private String swtbrd_no; // 배전반 번호 (Primary Key)
    private String pow_pop_no; // 수배전반 번호 (Foreign Key)
    private String makr_nm; // 제조사 이름
    private String model_nm; // 모델 이름
    private String instl_lc; // 설치 위치
    private String instl_de; // 설치 날짜
    private double instl_milg; // 설치 거리
    private String pero; // PERO 값
    private double x_crdnt; // X 좌표
    private double y_crdnt; // Y 좌표
}
