package com.highway.ventilation.domain.wdpblmrl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 풍향 풍속 고장 이력
 */
public class WdPblmrlSmDeffect {
    private String wd_pblmrl_sm_no;//풍향 풍속 번호(fk)
    private String link_id;//링크키(fk)
    private String occrrnc_dt;//발생 일시
    private String recovry_dt;//복구일시
    private String deffect_cn;//고장 내용
    private String managet_cn;//조치 내용
}
