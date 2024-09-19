package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 제트팬
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JetPan {
    private String jet_pan_id; // 기본키
    private String link_id; // 링크(fk)키
    private String instl_lc; // 설치위치
    private LocalDate instl_de; // 설치일자
}


