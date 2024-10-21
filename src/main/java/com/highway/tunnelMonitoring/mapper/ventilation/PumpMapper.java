package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanSttus;
import com.highway.tunnelMonitoring.domain.ventilation.pump.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface PumpMapper {
    List<Pump> pumpFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                           @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int pumpCountAll(@Param("link_id") String linkId);
    //하나만 조회

    //데이터 등록
    void pumpEnroll(Pump pump);


    void pumpSttusEnroll(@Param("pump_id") String pumpId, @Param("link_id") String linkId);

    //데이터 업데이트
    void pumpUpdate(Pump pump);

    //데이터 삭제
    void pumpDelete(Pump pump);

    List<PumpSttus> pumpMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int pumpMonitorCountAll(@Param("link_id") String linkId);

    int pumpFaultCountAll(@Param("link_id") String linkId,
                          @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    int pumpRunCountAll(@Param("link_id") String linkId,
                        @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    int pumpStatCountAll(@Param("link_id") String linkId,
                         @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<PumpFaultHistory> pumpFaultHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    List<PumpRunHistory> pumpRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                        @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                        @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    List<PumpStat> pumpStat(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    //매 자정 통계 기록
    void pumpRecordStat();



    PumpSttus pumpFindSttus(@Param("pump_id") String pumpId, @Param("link_id") String linkId);


    void pumpUpdateSttus(PumpSttus pumpSttus);


    void pumpCreateFaultHistory(PumpFaultHistory pumpFaultHistory);
    void pumpUpdateFaultHistory(PumpFaultHistory pumpFaultHistory);

    void pumpCreateRunHistory(PumpRunHistory pumpRunHistory);
    void pumpUpdateRunHistory(PumpRunHistory pumpRunHistory);
}
