package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCable;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface HeatingCableMapper {

    List<HeatingCable> heatingCableFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int heatingCableCountAll();
    //하나만 조회

    //데이터 등록
    void heatingCableEnroll(HeatingCable heatingCable);
    //데이터 업데이트
    void heatingCableUpdate(HeatingCable heatingCable);

    //데이터 삭제
    void heatingCableDelete(HeatingCable heatingCable);

    List<HeatingCableSttus> heatingCableMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int heatingCableMonitorCountAll();

    List<HeatingCableRunHistory> heatingCableRunHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<HeatingCableAlarmHistory> heatingCableAlarmHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int heatingCableRunCountAll();

    int heatingCableAlarmCountAll();
}
