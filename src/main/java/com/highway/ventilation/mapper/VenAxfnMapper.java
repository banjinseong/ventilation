package com.highway.ventilation.mapper;

import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.domain.venaxfn.VenAxfn;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.dto.VenAxfnGetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VenAxfnMapper {
    
    List<VenAxfn> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    VenAxfn findOne(String ven_axfn_no);
    //데이터 등록
    void enroll(VenAxfnGetDTO venAxfnGetDTO);
    //데이터 업데이트
    void update(VenAxfnGetDTO venAxfnGetDTO);

    //데이터 삭제
    void delete(String ven_axfn_no);
}
