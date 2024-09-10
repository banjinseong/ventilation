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
    List<WaterTank> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회

    //데이터 등록
    void enroll(WaterTank waterTank);
    //데이터 업데이트
    void update(WaterTank waterTank);

    //데이터 삭제
    void delete(WaterTank waterTank);

    List<WaterTankSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

    int monitorCountAll();

    int alarmCountAll();

    List<WaterTankAlarmHistory> alarmHistory(int offset, int size, LocalDateTime startDate, LocalDateTime endDate);
}
