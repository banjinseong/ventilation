package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.eld.Eld;
import com.highway.tunnelMonitoring.domain.power.eld.EldSttus;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EldMapper {
    List<Eld> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회

    //데이터 등록
    void enroll(Eld eld);
    //데이터 업데이트
    void update(Eld eld);

    //데이터 삭제
    void delete(Eld eld);

    List<EldSttus> monitor(@Param("offset") int offset, @Param("limit") int size);
}
