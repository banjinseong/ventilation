package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpSttus;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface VenAxFnMapper {
    
    List<VenAxFn> venAxFnFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                                 @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int venAxFnCountAll(@Param("link_id") String linkId);

    //데이터 등록
    void venAxFnEnroll(VenAxFn venAxfn);

    void venAxFnSttusEnroll(@Param("venAxFn_id") String venAxFnId, @Param("link_id") String linkId);

    //데이터 업데이트
    void venAxFnUpdate(VenAxFn venAxfn);

    //데이터 삭제
    void venAxFnDelete(VenAxFn venAxfn);

    List<VenAxFnSttus> venAxFnMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                      @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int venAxFnMonitorCountAll(@Param("link_id") String linkId);

    int venAxFnFaultCountAll(@Param("link_id") String linkId,
                             @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    int venAxFnRunCountAll(@Param("link_id") String linkId,
                           @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    int venAxFnStatCountAll(@Param("link_id") String linkId,
                            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<VenAxFnFaultHistory> venAxFnFaultHistory(@Param("link_id") String linkId,@Param("offset") int offset, @Param("limit") int size,
                                                  @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                  @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    List<VenAxFnRunHistory> venAxFnRunHistory(@Param("link_id") String linkId,@Param("offset") int offset, @Param("limit") int size,
                                              @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                              @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    List<VenAxFnStat> venAxFnStat(@Param("link_id") String linkId,@Param("offset") int offset, @Param("limit") int size,
                                  @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
                                  @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    //매 자정 통계 기록
    void venAxFnRecordStat();



    VenAxFnSttus venAxFnFindSttus(@Param("venAxFn_id") String venAxFnId, @Param("link_id") String linkId);


    void venAxFnUpdateSttus(VenAxFnSttus venAxFnSttus);

    void venAxFnCreateFaultHistory(VenAxFnFaultHistory faultHistory);
    void venAxFnUpdateFaultHistory(VenAxFnFaultHistory faultHistory);

    void venAxFnCreateRunHistory(VenAxFnRunHistory runHistory);
    void venAxFnUpdateRunHistory(VenAxFnRunHistory runHistory);
}
