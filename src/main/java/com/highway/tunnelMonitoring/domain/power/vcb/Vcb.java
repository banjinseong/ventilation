package com.highway.tunnelMonitoring.domain.power.vcb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 진공 차단기
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vcb {
    private String vcb_id; //기본키
    private String link_id; //링크아이디
    private String instl_lc; //설치위치
    private LocalDate instl_de; //설치일자
    private String model_nm; //모델넘버(이름)
}
