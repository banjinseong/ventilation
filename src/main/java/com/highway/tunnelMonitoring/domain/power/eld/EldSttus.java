package com.highway.tunnelMonitoring.domain.power.eld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EldSttus {
    private String eld_id;
    private String link_id;
    private String leakage_alarm;// 누전 경보
}
