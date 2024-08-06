package com.highway.tunnelMonitoring.domain.ventilation.wdpblmrl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 풍향 풍속 이력
 */
public class WdPblmrlHist {
    private String wd_pblmrl_sm_no;//풍향 풍속 번호(fk)
    private String link_id;//링크키(fk)
    private String meau_dt;//계측 일시(PK)
    private int pblmrl;//풍속
}
