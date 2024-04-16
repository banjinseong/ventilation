package com.highway.ventilation.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 피난 경문(피난문)정보
 */
public class RefgePouVO {
    private String pou_no; //기본키
    private String link_id; //링크(fk)키
    private String makr_nm; //제조사명
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private int instl_milg; //설치이정
    private int x_crdnt; //x좌표
    private int y_crdnt; //y좌표
}
