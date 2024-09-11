package com.highway.tunnelMonitoring.domain.power.entryentrbar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryEntrBar {
    private String entry_entr_bar_id; //기본키
    private String link_id;
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private String model_nm; //모델이름
}
