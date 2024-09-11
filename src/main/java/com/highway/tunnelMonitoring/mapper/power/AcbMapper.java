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
    List<Acb> findAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회

    //데이터 등록
    void enroll(Acb acb);
    //데이터 업데이트
    void update(Acb acb);

    //데이터 삭제
    void delete(Acb acb);

    List<AcbSttus> monitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    List<AcbAlarmHistory> alarmHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int monitorCountAll();

    int alarmCountAll();

    List<AcbRunHistory> runHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int runCountAll();
}
