package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.frplg.Frplg;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface FrplgMapper {
    
    List<Frplg> findAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //데이터 등록
    void enroll(Frplg frplg);
    //데이터 업데이트
    void update(Frplg frplg);

    //데이터 삭제
    void delete(Frplg frplg);

    List<FrplgSttus> monitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int monitorCountAll();

    List<FrplgAlarmHistory> alarmHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int alarmCountAll();
}
