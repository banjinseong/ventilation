package com.highway.tunnelMonitoring.dto.power.emgnctlphon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmgncTlphonDTO {
    private String emgnc_tlphon_no; //기본키
    private String makr_nm; //제조사명
    private String model_nm; //모델명
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private int instl_milg; //설치이정
    private String exchng_de; //교체일자
    private int x_crdnt; //x좌표
    private int y_crdnt; //y좌표
}
