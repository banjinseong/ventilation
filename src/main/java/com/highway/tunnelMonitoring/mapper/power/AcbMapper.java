package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.acb.Acb;
import com.highway.tunnelMonitoring.domain.power.acb.AcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.acb.AcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.acb.AcbSttus;

import com.highway.tunnelMonitoring.domain.power.ups.UpsRunHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface AcbMapper {
    List<Acb> acbFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int acbCountAll(@Param("link_id") String linkId);
    //하나만 조회

    //데이터 등록
    void acbEnroll(Acb acb);
    //데이터 업데이트
    void acbUpdate(Acb acb);

    //데이터 삭제
    void acbDelete(Acb acb);

    List<AcbSttus> acbMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    List<AcbAlarmHistory> acbAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int acbMonitorCountAll(@Param("link_id") String linkId);

    int acbAlarmCountAll(@Param("link_id") String linkId);

    List<AcbRunHistory> acbRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int acbRunCountAll(@Param("link_id") String linkId);
}
