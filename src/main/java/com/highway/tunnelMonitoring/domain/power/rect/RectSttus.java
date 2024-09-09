package com.highway.tunnelMonitoring.domain.power.rect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RectSttus {
    private String rect_no;
    private String link_id;
    private String change_dt; //변경일시
    private char low_vltge_alarm;//저 전압 경보 여부
    private double altrcrt_vltge_value;//교류전압값
    private double dctr_vltge_value; //직류전압값
    private double dctr_ercrt_1_value; //직류 전류 1 값
    private double dctr_ercrt_2_value; //직류 전류 2 값
}
