package com.highway.tunnelMonitoring.domain.power.lght;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lght {
    private String lght_group_no; // 조명 그룹 번호 (Primary Key)
    private String lght_knd; // 조명 종류 (Primary Key)
    private String makr_nm; //제조사명
    private String model_nm; //모델명
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private int instl_milg; //설치이정
    private String exchng_de; //교체일자
    private int x_crdnt; //x좌표
    private int y_crdnt; //y좌표
}
