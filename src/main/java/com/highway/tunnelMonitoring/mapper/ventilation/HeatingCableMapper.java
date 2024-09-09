package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCable;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HeatingCableMapper {

    List<HeatingCable> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회

    //데이터 등록
    void enroll(HeatingCable heatingCable);
    //데이터 업데이트
    void update(HeatingCable heatingCable);

    //데이터 삭제
    void delete(HeatingCable heatingCable);

    List<HeatingCableSttus> monitor(@Param("offset") int offset, @Param("limit") int size);
}
