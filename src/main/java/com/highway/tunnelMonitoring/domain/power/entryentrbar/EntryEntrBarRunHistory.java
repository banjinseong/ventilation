package com.highway.tunnelMonitoring.domain.power.entryentrbar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryEntrBarRunHistory {
    private String entry_entr_bar_id; //pk
    private String link_id;
    private LocalDateTime run_start_datetime;
    private LocalDateTime run_end_datetime;
}
