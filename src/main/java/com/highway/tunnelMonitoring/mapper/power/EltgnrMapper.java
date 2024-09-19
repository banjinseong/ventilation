package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.acb.AcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.Eltgnr;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrRunHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EltgnrMapper {
    
    List<Eltgnr> eltgnrFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int eltgnrCountAll(@Param("link_id") String linkId);
    //데이터 등록
    void eltgnrEnroll(Eltgnr eltgnr);
    //데이터 업데이트
    void eltgnrUpdate(Eltgnr eltgnr);

    //데이터 삭제
    void eltgnrDelete(Eltgnr eltgnr);

    List<EltgnrSttus> eltgnrMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int eltgnrMonitorCountAll(@Param("link_id") String linkId);

    int eltgnrAlarmCountAll(@Param("link_id") String linkId);

    List<EltgnrAlarmHistory> eltgnrAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);


    List<EltgnrRunHistory> eltgnrRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int eltgnrRunCountAll(@Param("link_id") String linkId);
}
