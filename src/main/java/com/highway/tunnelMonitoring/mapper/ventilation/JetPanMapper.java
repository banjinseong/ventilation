package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.jetpan.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface JetPanMapper {
    
    List<JetPan> jetPanFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                               @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int jetPanCountAll(@Param("link_id") String linkId);

    //데이터 등록
    void jetPanEnroll(JetPan jetPan);
    //데이터 업데이트
    void jetPanUpdate(JetPan jetPan);

    //데이터 삭제
    void jetPanDelete(JetPan jetPan);

    List<JetPanSttus> jetPanMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                    @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int jetPanMonitorCountAll(@Param("link_id") String linkId);

    int jetPanFaultCountAll(@Param("link_id") String linkId);

    int jetPanRunCountAll(@Param("link_id") String linkId);

    List<JetPanFaultHistory> jetPanFaultHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    List<JetPanRunHistory> jetPanRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int jetPanStatCountAll(@Param("link_id") String linkId);

    List<JetPanStat> jetPanStat(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    //매 자정 통계 기록
    void jetPanRecordStat();


    JetPanSttus jetPanFindSttus(@Param("jetPan_id") String jetPanId, @Param("link_id") String linkId);


    void jetPanUpdateSttus(JetPan jetPan);


    void jetPanCreateFaultHistory(JetPanFaultHistory jetPanFaultHistory);
    void jetPanUpdateFaultHistory(JetPanFaultHistory jetPanFaultHistory);

    void jetPanCreateRunHistory(JetPanRunHistory jetPanRunHistory);
    void jetPanUpdateRunHistory(JetPanRunHistory jetPanRunHistory);

}
