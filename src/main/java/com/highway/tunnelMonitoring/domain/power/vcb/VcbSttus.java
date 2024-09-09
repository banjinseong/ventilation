package com.highway.tunnelMonitoring.domain.power.vcb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VcbSttus {
    private String vcb_no; //기본키
    private String link_id;
    private boolean auto_remote_sttus; //원격 수동 상태
    private boolean run_sttus; //운전 상태
    private boolean ocr_alarm; //과전류 경보
    private boolean ocgr_alarm; //과전류 지락
    private boolean ovr_alarm; //과전압 경보
    private boolean uvr_alarm; //저전압 경보
    private boolean ovgr_alarm; //과전압 지락
    private boolean por_alarm; //결상 경보
}
