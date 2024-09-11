package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 축류팬 현황
 */
public class VenAxFnSttus {
    private String ven_axfn_id; //기본키
    private String link_id; //링크(fk)키
    private boolean remote_mode;
    private boolean run_sttus;
    private boolean fault_sttus;
}
