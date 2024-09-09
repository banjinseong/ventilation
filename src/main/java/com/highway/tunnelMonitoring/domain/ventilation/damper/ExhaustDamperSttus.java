package com.highway.tunnelMonitoring.domain.ventilation.damper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExhaustDamperSttus {
    private String damper_id;
    private String link_id;
    private boolean open_sttus;
    private boolean close_sttus;
}
