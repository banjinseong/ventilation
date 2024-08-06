package com.highway.tunnelMonitoring.domain.ventilation.inshlt;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 옥외 백엽상(온도측정 습도측정등)
 */
public class OuthousInshlt {
    private String inshlt_no; //기본키
    private String link_id; //링크(fk)키
    private String makr_nm; //제조사명
    private String model_nm; //모델명
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private int instl_milg; //설치이정
    private int x_crdnt; //x좌표
    private int y_crdnt; //y좌표
}
