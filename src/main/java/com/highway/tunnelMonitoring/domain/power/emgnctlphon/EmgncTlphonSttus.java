package com.highway.tunnelMonitoring.domain.power.emgnctlphon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmgncTlphonSttus {
    private String emgnc_tlphon_no; //pk
    private String link_id; //fk
    private String change_dt; //변경일자
    private char trobl_at; //장애여부
    private char call_at; //호출여부
}
