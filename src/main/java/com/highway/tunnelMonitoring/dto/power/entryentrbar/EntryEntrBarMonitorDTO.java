package com.highway.tunnelMonitoring.dto.power.entryentrbar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryEntrBarMonitorDTO {
    private String entry_entr_bar_no; //pk
    private String link_id; //fk
    private String change_dt; //변경일시
    private char intrcp_at; //차단여부
    private char rising_at; //상승여부
    private char desn_at; //하강여부

}
