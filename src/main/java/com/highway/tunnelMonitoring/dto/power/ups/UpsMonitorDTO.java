package com.highway.tunnelMonitoring.dto.power.ups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsMonitorDTO {
    private String ups_no; 
    private String change_dt; //변경일시
    private char trobl_at; //장애여부
    private char bypsss_at; //bypsss여부
}