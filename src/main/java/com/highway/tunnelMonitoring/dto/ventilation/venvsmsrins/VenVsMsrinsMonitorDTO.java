package com.highway.tunnelMonitoring.dto.ventilation.venvsmsrins;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenVsMsrinsMonitorDTO {
    private String link_id;//링크키(fk)
    private String ven_vs_msrins_no;//계측기 번호(fk)
    private String change_dt;//변경일시
    private int ven_vs;//가시도
    private boolean badn_at;//불량 여부
    private boolean fire_at;//화재 여부
}
