package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.pump.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface PumpMapper {
    List<Pump> findAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회

    //데이터 등록
    void enroll(Pump pump);
    //데이터 업데이트
    void update(Pump pump);

    //데이터 삭제
    void delete(Pump pump);

    List<PumpSttus> monitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int monitorCountAll();

    int faultCountAll();

    int runCountAll();

    int statCountAll();

    List<PumpFaultHistory> faultHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<PumpRunHistory> runHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<PumpStat> stat(@Param("link_id") String linkId, int offset, int size, LocalDate startDate, LocalDate endDate);
}
