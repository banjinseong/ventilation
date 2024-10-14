package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.frplg.FrplgSttus;
import com.highway.tunnelMonitoring.domain.power.rect.Rect;
import com.highway.tunnelMonitoring.domain.power.rect.RectAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.rect.RectSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    int rectAlarmCountAll(@Param("link_id") String linkId);

    List<RectAlarmHistory> rectAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    RectSttus rectFindSttus(@Param("rect_id") String rectId, @Param("link_id") String linkId);


    void RectUpadate(Rect rect);

    void rectCreateAlarmHistory(Rect rect);
    void rectUpdateAlarmHistory(Rect rect);

}
