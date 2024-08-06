package com.highway.tunnelMonitoring.domain.ventilation.jetpan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 제트팬 가동 이력
 */
public class JetPanOprHist {
    private String opr_begin_dt;//가동 시작 일시
    private String jet_pan_no;// 제트팬번호
    private String link_id;//링크키
    private String opr_stop_dt; // 가동 정지 일시
    private boolean opr_dire;// 가동 방면
    private int opr_ven_vs_meau_value;//가동 가시도 계측값
    private int opr_cmo_meau;// 가동 일산화탄소 계측
    private int stop_ven_vs_meau_value;//정지 가시도 계측값
    private int stop_cmo_meau;//정지 일산화탄소 계측
            
}
