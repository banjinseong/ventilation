package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.acb.AcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.acb.AcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.Vcb;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface VcbMapper {
    List<Vcb> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회

    //데이터 등록
    void enroll(Vcb vcb);
    //데이터 업데이트
    void update(Vcb vcb);

    //데이터 삭제
    void delete(Vcb vcb);

    List<VcbSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

    List<VcbAlarmHistory> alarmHistory(String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int alarmCountAll();

    int monitorCountAll();


    List<VcbRunHistory> runHistory(String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int runCountAll();
}
