package com.highway.ventilation.dto;

import com.highway.ventilation.domain.RefgePouVO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RefgePouGetDTO {
    private String makr_nm; //제조사명
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private int x_crdnt; //x좌표
    private int y_crdnt; //y좌표

    public RefgePouGetDTO(RefgePouVO refgePouVO){
        this.makr_nm = refgePouVO.getMakr_nm();
        this.instl_lc = refgePouVO.getInstl_lc();
        this.instl_de = refgePouVO.getInstl_de();
        this.x_crdnt = refgePouVO.getX_crdnt();
        this.y_crdnt = refgePouVO.getY_crdnt();
    }
}
