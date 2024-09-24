package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.frplg.Frplg;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface FrplgMapper {
    
    List<Frplg> frplgFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int frplgCountAll(@Param("link_id") String linkId);
    //데이터 등록
    void frplgEnroll(Frplg frplg);
    //데이터 업데이트
    void frplgUpdate(Frplg frplg);

    //데이터 삭제
    void frplgDelete(Frplg frplg);

    List<FrplgSttus> frplgMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int frplgMonitorCountAll(@Param("link_id") String linkId);

    List<FrplgAlarmHistory> frplgAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int frplgAlarmCountAll(@Param("link_id") String linkId);


    FrplgSttus frplgFindSttus(@Param("frplg_id") String frplgId, @Param("link_id") String linkId);

    void FrplgUpdateSttus(FrplgSttus frplgSttus);
}
