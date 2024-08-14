package com.highway.tunnelMonitoring.domain.power.powpop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowPopSttus {
    private String pow_pop_no;
    private String change_dt; //변경일시
    private char kepc_srcelct_suply_at;//한전 전원 공급 여부
}
