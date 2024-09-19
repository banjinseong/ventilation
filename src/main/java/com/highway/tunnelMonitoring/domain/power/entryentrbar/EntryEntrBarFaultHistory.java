package com.highway.tunnelMonitoring.domain.power.entryentrbar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryEntrBarFaultHistory {
    private String entry_entr_bar_id; //pk
    private String link_id; //fk
    private LocalDateTime fault_start_datetime; //고장 시작시간
    private LocalDateTime fault_end_datetime; //고장 해결 시간
}
