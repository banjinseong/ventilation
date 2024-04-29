package com.highway.ventilation.domain.refgepou;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 피난 갱문 개폐 이력
 */
public class RefgePouRorgnHist {
    private String pou_no;//갱문 번호(fk)
    private String link_id;//링크키(fk)
    private String oppn_dt;//열림 일시(pk)
    private String cls_dt;//폐쇄 일시
}
