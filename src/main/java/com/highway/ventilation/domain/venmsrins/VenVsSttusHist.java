package com.highway.ventilation.domain.venmsrins;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 가시도 상태 이력
 */
public class VenVsSttusHist {
    private String link_id;//링크키(fk)
    private String ven_vs_msrins_no;//계측기 번호(fk)
    private String badn_occrrnc_dt;//불량 발생 일시(pk)
    private String badn_relis_dt;//불량 해제 일시
    private int occrrnc_meau_value;//발생 계측값
    private int relis_meau_value;//해제 계측값
}
