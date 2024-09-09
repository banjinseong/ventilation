package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.acb.Acb;
import com.highway.tunnelMonitoring.domain.power.acb.AcbSttus;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcbMapper {
    List<Acb> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회

    //데이터 등록
    void enroll(Acb acb);
    //데이터 업데이트
    void update(Acb acb);

    //데이터 삭제
    void delete(Acb acb);

    List<AcbSttus> monitor(@Param("offset") int offset, @Param("limit") int size);
}
