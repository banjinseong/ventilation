package com.highway.tunnelMonitoring.domain.ventilation.fire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FireSttus {

    private String link_id;
    private boolean fire_sttus; // 현재 화재 상태
}
