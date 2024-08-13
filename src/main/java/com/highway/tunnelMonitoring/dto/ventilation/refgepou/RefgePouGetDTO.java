package com.highway.tunnelMonitoring.dto.ventilation.refgepou;

import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePou;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefgePouGetDTO {
    @NotNull
    private String pou_no;
    @NotNull
    private String makr_nm; //제조사명
    private String instl_lc; //설치위치
    private String instl_de; //설치일자
    private int instl_milg; //설치이정
    private int x_crdnt; //x좌표
    private int y_crdnt; //y좌표

    public RefgePouGetDTO(RefgePou refgePouVO){
        this.pou_no = refgePouVO.getPou_no();
        this.makr_nm = refgePouVO.getMakr_nm();
        this.instl_lc = refgePouVO.getInstl_lc();
        this.instl_de = refgePouVO.getInstl_de();
        this.instl_milg = refgePouVO.getInstl_milg();
        this.x_crdnt = refgePouVO.getX_crdnt();
        this.y_crdnt = refgePouVO.getY_crdnt();
    }
}
