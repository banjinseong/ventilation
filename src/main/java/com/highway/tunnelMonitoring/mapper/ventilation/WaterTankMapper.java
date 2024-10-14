package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpSttus;
import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTank;
import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTankAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTankSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface WaterTankMapper {
    List<WaterTank> waterTankFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                                     @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int waterTankCountAll(@Param("link_id") String linkId);
    //하나만 조회

    //데이터 등록
    void waterTankEnroll(WaterTank waterTank);
    //데이터 업데이트
    void waterTankUpdate(WaterTank waterTank);

    //데이터 삭제
    void waterTankDelete(WaterTank waterTank);

    List<WaterTankSttus> waterTankMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                          @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int waterTankMonitorCountAll(@Param("link_id") String linkId);

    int waterTankAlarmCountAll(@Param("link_id") String linkId);

    List<WaterTankAlarmHistory> waterTankAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                      @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                      @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);




    WaterTankSttus tankFindSttus(@Param("tank_id") String tankId, @Param("link_id") String linkId);


    void tankUpdateSttus(WaterTankSttus waterTankSttus);


    void waterTankCreateAlarmHistory(WaterTankAlarmHistory waterTankAlarmHistory);
    void waterTankUpdateAlarmHistory(WaterTankAlarmHistory waterTankAlarmHistory);
}
