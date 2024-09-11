package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTank;
import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTankAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTankSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface WaterTankMapper {
    List<WaterTank> waterTankFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int waterTankCountAll();
    //하나만 조회

    //데이터 등록
    void waterTankEnroll(WaterTank waterTank);
    //데이터 업데이트
    void waterTankUpdate(WaterTank waterTank);

    //데이터 삭제
    void waterTankDelete(WaterTank waterTank);

    List<WaterTankSttus> waterTankMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int waterTankMonitorCountAll();

    int waterTankAlarmCountAll();

    List<WaterTankAlarmHistory> waterTankAlarmHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);
}
