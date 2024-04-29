package com.highway.ventilation.domain.inshlt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 옥외 풍향 풍속 이력
 */
public class OuthousWdPblmrlHist {
    private String inshlt_no;//백엽상 번호(fk)
    private String link_id;//링크키(fk)
    private String meau_dt;//계측 일시
    private int pblmrl;//풍속
    private String wd;//풍향
}
