package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.frplg.FrplgSttus;
import com.highway.tunnelMonitoring.domain.power.rect.Rect;
import com.highway.tunnelMonitoring.domain.power.rect.RectAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.rect.RectSttus;
import com.highway.tunnelMonitoring.domain.power.rect.RectStat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface RectMapper {

    List<Rect> rectFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                           @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int rectCountAll(@Param("link_id") String linkId);

    //데이터 등록
    void rectEnroll(Rect rect);

    //데이터 업데이트
    void rectUpdate(Rect rect);

    //데이터 삭제
    void rectDelete(Rect rect);

    List<RectSttus> rectMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int rectMonitorCountAll(@Param("link_id") String linkId);

    int rectAlarmCountAll(@Param("link_id") String linkId,
                          @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    List<RectAlarmHistory> rectAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    int rectStatCountAll(@Param("link_id") String linkId,
                           @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<RectStat> rectStat(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    //매 자정 통계 기록
    void rectRecordStat();


    RectSttus rectFindSttus(@Param("rect_id") String rectId, @Param("link_id") String linkId);


    void RectUpadate(Rect rect);

    void rectCreateAlarmHistory(Rect rect);
    void rectUpdateAlarmHistory(Rect rect);

}
