package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.eld.Eld;
import com.highway.tunnelMonitoring.domain.power.eld.EldAlarmHistroy;
import com.highway.tunnelMonitoring.domain.power.eld.EldSttus;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EldMapper {
    List<Eld> eldFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int eldCountAll(@Param("link_id") String linkId);
    //하나만 조회

    //데이터 등록
    void eldEnroll(Eld eld);
    //데이터 업데이트
    void eldUpdate(Eld eld);

    //데이터 삭제
    void eldDelete(Eld eld);

    List<EldSttus> eldMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int eldMonitorCountAll(@Param("link_id") String linkId);

    List<EldAlarmHistroy> eldAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int eldAlarmCountAll(@Param("link_id") String linkId);

    EldSttus eldFindSttus(@Param("eld_id") String eldId, @Param("link_id") String linkId);


    void eldUpdateSttus(EldSttus eldSttus);
}
