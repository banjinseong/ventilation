package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.pump.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface PumpMapper {
    List<Pump> pumpFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int pumpCountAll(@Param("link_id") String linkId);
    //하나만 조회

    //데이터 등록
    void pumpEnroll(Pump pump);
    //데이터 업데이트
    void pumpUpdate(Pump pump);

    //데이터 삭제
    void pumpDelete(Pump pump);

    List<PumpSttus> pumpMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int pumpMonitorCountAll(@Param("link_id") String linkId);

    int pumpFaultCountAll(@Param("link_id") String linkId);

    int pumpRunCountAll(@Param("link_id") String linkId);

    int pumpStatCountAll(@Param("link_id") String linkId);

    List<PumpFaultHistory> pumpFaultHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<PumpRunHistory> pumpRunHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<PumpStat> pumpStat(@Param("link_id") String linkId, int offset, int size, LocalDate startDate, LocalDate endDate);
}
