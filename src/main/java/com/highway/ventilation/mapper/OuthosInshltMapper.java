package com.highway.ventilation.mapper;

import com.highway.ventilation.domain.inshlt.OuthousInshlt;
import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.dto.OuthousInshltGetDTO;
import com.highway.ventilation.dto.RefgePouGetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OuthosInshltMapper {
    
    List<OuthousInshlt> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    OuthousInshlt findOne(String inshlt_no);
    //데이터 등록
    void enroll(OuthousInshltGetDTO outhousInshltGetDTO);
    //데이터 업데이트
    void update(OuthousInshltGetDTO outhousInshltGetDTO);

    //데이터 삭제
    void delete(String inshlt_no);
}
