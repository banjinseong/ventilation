package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.frplg.Frplg;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FrplgMapper {
    
    List<Frplg> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    Frplg findOne(String frplg_no);
    //데이터 등록
    void enroll(Frplg frplg);
    //데이터 업데이트
    void update(Frplg frplg);

    //데이터 삭제
    void delete(Frplg frplg);

    List<FrplgSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
