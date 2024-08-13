package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.Frplg;
import com.highway.tunnelMonitoring.dto.power.frplg.FrplgDTO;
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
    void enroll(FrplgDTO frplg);
    //데이터 업데이트
    void update(FrplgDTO frplg);

    //데이터 삭제
    void delete(String frplg_no);
}
