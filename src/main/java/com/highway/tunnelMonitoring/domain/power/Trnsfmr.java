package com.highway.tunnelMonitoring.domain.power;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 변압기 (Trnsfmr)
 */
public class Trnsfmr {

    private String trnsfmr_no; // 변압기 번호 (Primary Key)
    private String pow_pop_no; // 수배전반 번호 (Foreign Key)
    private String makr_nm; // 제조사 이름
    private String model_nm; // 모델 이름
}

