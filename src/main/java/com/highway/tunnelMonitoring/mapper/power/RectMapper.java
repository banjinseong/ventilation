package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.rect.Rect;
import com.highway.tunnelMonitoring.domain.power.rect.RectAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.rect.RectSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface RectMapper {
    
    List<Rect> rectFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int rectCountAll();

    //데이터 등록
    void rectEnroll(Rect rect);
    //데이터 업데이트
    void rectUpdate(Rect rect);

    //데이터 삭제
    void rectDelete(Rect rect);

    List<RectSttus> rectMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int rectMonitorCountAll();

    int rectAlarmCountAll();

    List<RectAlarmHistory> rectAlarmHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);
}
