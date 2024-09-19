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
    List<TempHum> tempHumFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int tempHumCountAll(@Param("link_id") String linkId);

    //하나만 조회
//    JetPan findOne(String jet_pan_no);
    //데이터 등록
    void tempHumEnroll(TempHum tempHum);
    //데이터 업데이트
    void tempHumUpdate(TempHum tempHum);

    //데이터 삭제
    void tempHumDelete(TempHum tempHum);

    List<TempHumSttus> tempHumMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int tempHumMonitorCountAll(@Param("link_id") String linkId);
}
