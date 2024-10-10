package com.highway.tunnelMonitoring.domain.power.lght;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LghtSttus {

    private String lght_id; //기본키
    private String link_id; //링크아이디
    private boolean nlt_sttus; //심야등 상태
    private boolean dlt_sttus; //주간등 상태
    private int lght_lvl;  //조명 단계(1~21)
}
