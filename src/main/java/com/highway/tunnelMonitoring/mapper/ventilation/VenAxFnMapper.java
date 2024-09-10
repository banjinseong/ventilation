package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface VenAxFnMapper {
    
    List<VenAxFn> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    VenAxFn findOne(String ven_axfn_no);
    //데이터 등록
    void enroll(VenAxFn venAxfn);
    //데이터 업데이트
    void update(VenAxFn venAxfn);

    //데이터 삭제
    void delete(VenAxFn venAxfn);

    List<VenAxFnSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

    int monitorCountAll();

    int faultCountAll();

    int runCountAll();

    int statCountAll();

    List<VenAxFnFaultHistory> faultHistory(String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<VenAxFnRunHistory> runHistory(String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<VenAxFnStat> stat(String linkId, int offset, int size, LocalDate startDate, LocalDate endDate);
}
