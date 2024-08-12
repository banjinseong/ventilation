package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.Ups;
import com.highway.tunnelMonitoring.dto.power.UpsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UpsMapper {
    
    List<Ups> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    Ups findOne(String ups_no);
    //데이터 등록
    void enroll(UpsDTO ups);
    //데이터 업데이트
    void update(UpsDTO ups);

    //데이터 삭제
    void delete(String ups_no);
}
