package com.highway.ventilation.domain.inshlt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 옥외 기상 현황
 */
public class OuthousWetherSttus {
    private String inshlt_no;//백엽상 번호(fk)
    private String link_id;//링크키(fk)
    private String change_dt;//변경 일시
    private int tp;//온도
    private int hd;//습도
    private int arcsr;//기압
    private String wd;//풍향
    private int pblmrl;//풍속
}
