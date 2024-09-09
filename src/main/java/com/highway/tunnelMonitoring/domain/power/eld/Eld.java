package com.highway.tunnelMonitoring.domain.power.eld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 누전
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eld {
    private String eld_id;
    private String link_id;
    private String instl_lc; // 설치 위치
    private String instl_de; // 설치 날짜
    private String model_nm;
}
