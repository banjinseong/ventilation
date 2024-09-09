package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.pump.Pump;
import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PumpMapper {
    List<Pump> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회

    //데이터 등록
    void enroll(Pump pump);
    //데이터 업데이트
    void update(Pump pump);

    //데이터 삭제
    void delete(Pump pump);

    List<PumpSttus> monitor(@Param("offset") int offset, @Param("limit") int size);
}
