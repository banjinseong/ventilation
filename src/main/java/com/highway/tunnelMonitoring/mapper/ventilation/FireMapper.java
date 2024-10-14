package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.fire.FireAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.fire.FireStat;
import com.highway.tunnelMonitoring.domain.ventilation.fire.FireSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper

public interface FireMapper {


    List<FireSttus> fireMonitor(@Param("offset") int offset, @Param("limit") int size,
                                  @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int fireMonitorCountAll();

    int fireAlarmCountAll(@Param("link_id") String linkId);

    List<FireAlarmHistory> fireAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                              @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                              @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int fireStatCountAll();

    List<FireStat> fireStat(@Param("offset") int offset, @Param("limit") int size,
                              @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
                              @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    //매 자정 통계 기록
    void fireRecordStat();


    FireSttus fireFindSttus(@Param("link_id") String linkId);


    void FireUpdateSttus(FireSttus fireSttus);

    void fireCreateAlarmHistory(FireAlarmHistory fireAlarmHistory);
    void fireUpdateAlarmHistory(FireAlarmHistory fireAlarmHistory);

}
