package com.highway.tunnelMonitoring.domain.power.ups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ups {
    private String ups_no; // UPS 번호 (Primary Key)
    private String link_id;
    private String instl_lc; // 설치 위치
    private String instl_de; // 설치 날짜
    private String model_nm;
}
