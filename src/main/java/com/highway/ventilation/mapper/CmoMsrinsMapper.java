package com.highway.ventilation.mapper;

import com.highway.ventilation.domain.CO.CmoMsrins;
import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.dto.CmoMsrinsGetDTO;
import com.highway.ventilation.dto.RefgePouGetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CmoMsrinsMapper {
    
    List<CmoMsrins> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    CmoMsrins findOne(String cmo_msrins_no);
    //데이터 등록
    void enroll(CmoMsrinsGetDTO cmoMsrinsGetDTO);
    //데이터 업데이트
    void update(CmoMsrinsGetDTO cmoMsrinsGetDTO);

    //데이터 삭제
    void delete(String cmo_msrins_no);
}
