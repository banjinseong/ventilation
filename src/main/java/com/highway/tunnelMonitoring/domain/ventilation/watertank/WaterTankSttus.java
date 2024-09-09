package com.highway.tunnelMonitoring.domain.ventilation.watertank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterTankSttus {
    private String tank_id;
    private String link_id;
    private boolean high_water_alarm; //고수위 경보
    private boolean low_water_alarm; //저수위 경보
    private boolean current_water_alarm;//현재 수위
}
