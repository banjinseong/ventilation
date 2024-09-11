package com.highway.tunnelMonitoring.domain.power.entryentrbar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryEntrBarRunHistory {
    private String entry_entr_bar_id; //pk
    private String link_id;
    private String run_start_datetime;
    private String run_end_datetime;
}
