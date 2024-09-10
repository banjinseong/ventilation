package com.highway.tunnelMonitoring.mapper.ventilation;


import com.highway.tunnelMonitoring.domain.ventilation.temphum.TempHum;
import com.highway.tunnelMonitoring.domain.ventilation.temphum.TempHumSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  온_습도 좀 알아봐야할듯.
 */
@Mapper
public interface TempHumMapper {
    List<TempHum> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();

    //하나만 조회
//    JetPan findOne(String jet_pan_no);
    //데이터 등록
    void enroll(TempHum tempHum);
    //데이터 업데이트
    void update(TempHum tempHum);

    //데이터 삭제
    void delete(TempHum tempHum);

    List<TempHumSttus> monitor(@Param("offset") int offset, @Param("limit") int size);
}
