package com.highway.tunnelMonitoring.domain.ventilation.temphum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempHumSttus {
    private String temp_hum_id;
    private String link_id;
    private float temp;//온도
    private float hum; //습도
}
