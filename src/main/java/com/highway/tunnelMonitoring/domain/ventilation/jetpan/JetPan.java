package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.Getter;
import lombok.Setter;

/**
 * 제트팬
 */
@Getter
@Setter
public class JetPan {

    private String jet_pan_no; // 기본키
    private String link; // 링크(fk)키
    private String makr_nm; // 제조사명
    private String model_nm; // 모델명
    private String instl_lc; // 설치위치
    private String instl_de; // 설치일자
    private int instl_milg; // 설치이정
    private int pero; // 내구연한
    private char delete_at; // 삭제여부
    private int x_crdnt; // x좌표
    private int y_crdnt; // y좌표
    private String ven_vs_msrins_no; // 가시도(fk)키
    private String cmo_msrins_no; // 일산화탄소(fk)키
    private String wd_pblmrl_sm_no; // 풍향(fk)키
    private String inshlt_no; // 백엽상(fk)키
}


