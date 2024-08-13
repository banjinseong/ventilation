package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.Eltgnr;
import com.highway.tunnelMonitoring.dto.power.eltgnr.EltgnrDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EltgnrMapper {
    
    List<Eltgnr> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    Eltgnr findOne(String eltgnr_no);
    //데이터 등록
    void enroll(EltgnrDTO eltgnrDTO);
    //데이터 업데이트
    void update(EltgnrDTO eltgnrDTO);

    //데이터 삭제
    void delete(String eltgnr_no);
}
