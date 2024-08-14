package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.eltgnr.Eltgnr;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrSttus;
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
    void enroll(Eltgnr eltgnr);
    //데이터 업데이트
    void update(Eltgnr eltgnr);

    //데이터 삭제
    void delete(String eltgnr_no);

    List<EltgnrSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
