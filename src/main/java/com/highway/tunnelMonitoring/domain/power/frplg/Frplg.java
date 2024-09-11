package com.highway.tunnelMonitoring.domain.power.frplg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Frplg {
    private String frplg_id; //기본키
    private String link_id;
    private String instl_lc; //설치위치
    private String model_nm;
}
