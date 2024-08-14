package com.highway.tunnelMonitoring.domain.power.lght;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LghtSttus {
    private String lght_group_no;
    private String lght_knd;
    private int lght_sttus;//점등상태
    private double ilun;//조도
}
