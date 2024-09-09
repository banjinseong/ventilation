package com.highway.tunnelMonitoring.domain.ventilation.temphum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempHum {
    private String temp_hum_id;
    private String link_id;
    private String model_nm;
}
