package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.jetpan.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface JetPanMapper {
    
    List<JetPan> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    JetPan findOne(String jet_pan_no);
    //데이터 등록
    void enroll(JetPan jetPan);
    //데이터 업데이트
    void update(JetPan jetPan);

    //데이터 삭제
    void delete(JetPan jetPan);

    List<JetPanSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

    int monitorCountAll();

    int faultCountAll();

    int runCountAll();

    List<JetPanFaultHistory> faultHistory(String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    List<JetPanRunHistory> runHistory(String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int statCountAll();

    List<JetPanStat> stat(String linkId, int offset, int size, LocalDate startDate, LocalDate endDate);
}
