package com.highway.tunnelMonitoring.domain.power.ups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsSttus {
    private String ups_id;
    private String link_id;
    private boolean run_sttus;  //동작여부
    private boolean fault_sttus;  //고장여부
    private boolean bypsss_sttus; //bypsss여부
}
