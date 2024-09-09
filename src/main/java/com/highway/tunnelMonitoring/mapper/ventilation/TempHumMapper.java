package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCable;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  온_습도 좀 알아봐야할듯.
 */
@Mapper
public interface TempHumMapper {
    List<HeatingCable> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();

    //데이터 업데이트
    void update(HeatingCable venAxfn);

    List<HeatingCableSttus> monitor(@Param("offset") int offset, @Param("limit") int size);
}
