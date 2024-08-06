package com.highway.tunnelMonitoring.domain.ventilation.CO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 일산화탄소 계측
 */
public class CmoMsrins {
    private String cmo_msrins_no; //기본키
    private String link_id; //링크(fk)키
    private String makr_nm; //제조사명
    private String model_nm; //모델명
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private int instl_milg; //설치이정
    private String exchng_de; //교체일자
    private int x_crdnt; //x좌표
    private int y_crdnt; //y좌표
}
