package com.highway.ventilation.domain.venaxfn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 축류팬 고장 이력
 */
public class VenAxfnDefect {
    private String link_id;//링크키(fk)
    private String ven_axfn_no;//축류팬 번호(fk)
    private char defect_kind; //고장 종류
    private String occrrnc_dt;//발생 일시
    private String recovry_dt;//복구일시
    private String defect_cn;//고장 내용
    private String managt_cn;//조치내용
    
}
