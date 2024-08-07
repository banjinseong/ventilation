package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.EmgncTlphon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmgncTlphonMapper {
    
    List<EmgncTlphon> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    EmgncTlphon findOne(String emgnc_tlphon_no);
    //데이터 등록
    void enroll(EmgncTlphon emgncTlphon);
    //데이터 업데이트
    void update(EmgncTlphon emgncTlphon);

    //데이터 삭제
    void delete(String emgnc_tlphon_no);
}
