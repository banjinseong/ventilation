package com.highway.tunnelMonitoring.domain.power.acb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 기중 차단기
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acb {
    private String acb_no; //기본키
    private String link_id; //링크아이디
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private String model_nm; //모델넘버(이름)
}
