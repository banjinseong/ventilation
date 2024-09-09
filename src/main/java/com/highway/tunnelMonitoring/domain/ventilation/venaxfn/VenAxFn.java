package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 축류팬 정보
 */
public class VenAxFn {
    private String ven_axfn_no; //기본키
    private String link_id; //링크(fk)키
    private String fan_type; //배기/급기 타입
    private String instl_lc; //설치위치
    private String instl_de; //설치일자

}
