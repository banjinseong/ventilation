package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.*;

/**
 * 제트팬
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JetPan {
    private String jet_pan_no; // 기본키
    private String link; // 링크(fk)키
    private String instl_lc; // 설치위치
    private String instl_de; // 설치일자
}


