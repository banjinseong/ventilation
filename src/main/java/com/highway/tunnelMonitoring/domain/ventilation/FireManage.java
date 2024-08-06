package com.highway.tunnelMonitoring.domain.ventilation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 화재 관리
 */
public class FireManage {
    private String incdnt_no; //기본키
    private String occrrnc_dt; //발생일시
    private String occrrnc_papstmp_mth; //발생 인지 방법
    private int x_crdnt; //x좌표
    private int y_crdnt; //y좌표
    private int occrrnc_milg; //발생 이정
    private String cntrmsr_managt_cn; //대응조치내용
    private String end_dt; //종료일시
    private String end_cn; //종료내용
    private String managt_evl; //조치평가
    private String evl_detail_cn; //평가세부내용
}
