package com.highway.tunnelMonitoring.domain.ventilation.CO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 일산화탄소 상태 이력
 */
public class CmoSttusHist {
    private String badn_occrrnc_dt;//불량 발생 일시(pk)
    private String cmo_msrins_no;//일산화탄소 계측기 번호
    private String link_id;// 링크 키
    private String badn_relis_dt;//불량 해제 일시
    private int occrrnc_meau_value;// 발생 계측 값
    private int relis_meau_value;// 해제 계측 값
}
