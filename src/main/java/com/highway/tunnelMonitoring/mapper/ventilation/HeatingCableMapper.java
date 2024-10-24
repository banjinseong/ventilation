package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.damper.ExhaustDamperSttus;
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

    List<HeatingCable> heatingCableFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                                           @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int heatingCableCountAll(@Param("link_id") String linkId);
    //하나만 조회

    //데이터 등록
    void heatingCableEnroll(HeatingCable heatingCable);

    void heatingCableSttusEnroll(@Param("cable_id") String cableId, @Param("link_id") String linkId);

    //데이터 업데이트
    void heatingCableUpdate(HeatingCable heatingCable);

    //데이터 삭제
    void heatingCableDelete(HeatingCable heatingCable);

    List<HeatingCableSttus> heatingCableMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int heatingCableMonitorCountAll(@Param("link_id") String linkId);

    List<HeatingCableRunHistory> heatingCableRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                        @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                        @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    List<HeatingCableAlarmHistory> heatingCableAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int heatingCableRunCountAll(@Param("link_id") String linkId,
                                @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    int heatingCableAlarmCountAll(@Param("link_id") String linkId,
                                  @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


    HeatingCableSttus cableFindSttus(@Param("cable_id") String cableId, @Param("link_id") String linkId);


    void cableUpdateSttus(HeatingCableSttus heatingCableSttus);

    void heatingCableCreateAlarmHistory(HeatingCableAlarmHistory heatingCableAlarmHistory);
    void heatingCableUpdateAlarmHistory(HeatingCableAlarmHistory heatingCableAlarmHistory);

    void heatingCableCreateRunHistory(HeatingCableRunHistory heatingCableRunHistory);
    void heatingCableUpdateRunHistory(HeatingCableRunHistory heatingCableRunHistory);
}
