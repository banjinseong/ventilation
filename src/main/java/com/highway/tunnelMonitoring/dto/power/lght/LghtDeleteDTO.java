package com.highway.tunnelMonitoring.dto.power.lght;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LghtDeleteDTO {
    private String lght_group_no; // 조명 그룹 번호 (Primary Key)
    private String lght_knd; // 조명 종류 (Primary Key)
}
