package com.highway.tunnelMonitoring.domain.ventilation.venaxfn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenAxFnFaultHistory {
    private String ven_axfn_no; //기본키
    private String link_id; //링크(fk)키
    private String fault_start_datetime; //고장 시작시간
    private String fault_end_datetime; //고장 해결 시간
}
