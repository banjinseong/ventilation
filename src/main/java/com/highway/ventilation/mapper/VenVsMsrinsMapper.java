package com.highway.ventilation.mapper;

import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.domain.venmsrins.VenVsMsrins;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.dto.VenVsMsrinsGetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VenVsMsrinsMapper {
    
    List<VenVsMsrins> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    VenVsMsrins findOne(String ven_vs_msrins_no);
    //데이터 등록
    void enroll(VenVsMsrinsGetDTO venVsMsrinsGetDTO);
    //데이터 업데이트
    void update(VenVsMsrinsGetDTO venVsMsrinsGetDTO);

    //데이터 삭제
    void delete(String ven_vs_msrins_no);
}
