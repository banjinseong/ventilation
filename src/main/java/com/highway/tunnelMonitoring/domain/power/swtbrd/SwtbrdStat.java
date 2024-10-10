package com.highway.tunnelMonitoring.domain.power.swtbrd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwtbrdStat {
    private String swtbrd_id; //기본키
    private String link_id; //링크아이디

    private double valid_pwrer_stat;// 전력 통계
    private double r_uppt_ercrt_statt; //R상 전류 통계
    private double s_uppt_ercrt_statt; //S상 전류 통계
    private double t_uppt_ercrt_statt; //T상 전류 통계
    private boolean ocr_count; //과전류 횟수

}
