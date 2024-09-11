package com.highway.tunnelMonitoring.domain.power.entryentrbar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryEntrBarSttus {
    private String entry_entr_bar_id; //pk
    private String link_id; //fk
    private boolean auto_remote_sttus; //원격 수동 상태
    private boolean run_sttus; //동작중
    private boolean rising_sttus; //상승여부
    private boolean desn_sttus; //하강여부
    private boolean fault_sttus;//고장여부
}
