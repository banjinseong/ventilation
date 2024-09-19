package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 축류팬 정보
 */
public class VenAxFn {
    private String ven_ax_fn_id; //기본키
    private String link_id; //링크(fk)키
    private String fan_type; //배기/급기 타입
    private String instl_lc; //설치위치
    private LocalDate instl_de; //설치일자

}
