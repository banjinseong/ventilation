package com.highway.ventilation.domain.jetpan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 제트팬 고장 이력
 */
public class JetPanDefectHist {
    private String jet_pan_no;// 제트팬번호(fk)
    private String link_id;//링크키(fk)
    private String occrrnc_dt;//고장 발생 일시(pk)
    private String recovry_dt;// 복구 일시
    private String defect_cn;//고장 내용
    private String managt_cn;// 조치 내용
}
