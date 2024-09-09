package com.highway.tunnelMonitoring.domain.ventilation.heatingcable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 히팅케이블
 */
public class HeatingCable {
    private String cable_id;
    private String link_id;
    private String instl_de;
    private String model_nm;
}
