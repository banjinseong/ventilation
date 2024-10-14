package com.highway.tunnelMonitoring.domain.power.rect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RectStat {
    private String rect_id; // 정류기 번호 (Primary Key)
    private String link_id;
    private LocalDate record_date; //기록일(통계일)
    private int low_vltge_count;//저 전압 경보 횟수
    private double altrcrt_vltge_stat;//교류전압값 통계
    private double dctr_vltge_stat; //직류전압값 통계
    private double dctr_ercrt_stat; //(직류) 전류 통계
}
