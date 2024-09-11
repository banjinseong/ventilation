package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.jetpan.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface JetPanMapper {
    
    List<JetPan> jetPanFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int jetPanCountAll();

    //데이터 등록
    void jetPanEnroll(JetPan jetPan);
    //데이터 업데이트
    void jetPanUpdate(JetPan jetPan);

    //데이터 삭제
    void jetPanDelete(JetPan jetPan);

    List<JetPanSttus> jetPanMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int jetPanMonitorCountAll();

    int jetPanFaultCountAll();

    int jetPanRunCountAll();

    List<JetPanFaultHistory> jetPanFaultHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<JetPanRunHistory> jetPanRunHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int jetPanStatCountAll();

    List<JetPanStat> jetPanStat(@Param("link_id") String linkId, int offset, int size, LocalDate startDate, LocalDate endDate);
}
