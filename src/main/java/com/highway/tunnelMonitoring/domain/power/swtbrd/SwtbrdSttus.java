package com.highway.tunnelMonitoring.domain.power.swtbrd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwtbrdSttus {
    private String swtbrd_id; //기본키
    private String link_id;
    private boolean auto_remote_sttus; //원격 수동 상태
    private boolean run_sttus; //운전 상태
    private boolean ocr_alarm; //과전류 경보
    private boolean ocgr_alarm; //과전류 지락
    private boolean ovr_alarm; //과전압 경보
    private boolean uvr_alarm; //저전압 경보
    private boolean ovgr_alarm; //과전압 지락
    private boolean por_alarm; //결상 경보

    private double r_uppt_vltge; //R-S 선간전압
    private double s_uppt_vltge; //S-T 선간전압
    private double t_uppt_vltge; //T-R 선간전압
    private double r_uppt_ercrt; //R상 전류
    private double s_uppt_ercrt; //S상 전류
    private double t_uppt_ercrt; //T상 전류
    private double valid_pwrer;// 전력
    private double valid_pwrer_qy; // 전력량
    private double pf; //역률
    private double fqnc; //주파수

}










