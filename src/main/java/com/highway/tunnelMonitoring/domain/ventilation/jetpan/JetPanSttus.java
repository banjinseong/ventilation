package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 제트팬 현황
 */
public class JetPanSttus {
    private String jet_pan_id;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private boolean remote_mode; //원격/수동
    private boolean forward_mode; //정방향
    private boolean reverse_mode; //역방향
    private boolean fault_sttus; //고장상태
}
