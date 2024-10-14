package com.highway.tunnelMonitoring.mapper.power;

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
    
    List<Eltgnr> eltgnrFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                               @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int eltgnrCountAll(@Param("link_id") String linkId);
    //데이터 등록
    void eltgnrEnroll(Eltgnr eltgnr);
    //데이터 업데이트
    void eltgnrUpdate(Eltgnr eltgnr);

    //데이터 삭제
    void eltgnrDelete(Eltgnr eltgnr);

    List<EltgnrSttus> eltgnrMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                    @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int eltgnrMonitorCountAll(@Param("link_id") String linkId);

    int eltgnrAlarmCountAll(@Param("link_id") String linkId,
                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    List<EltgnrAlarmHistory> eltgnrAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    List<EltgnrRunHistory> eltgnrRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int eltgnrRunCountAll(@Param("link_id") String linkId,
                          @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


    EltgnrSttus eltgnrFindSttus(@Param("eltgnr_id") String eltgnrId, @Param("link_id") String linkId);


    void EltgnrUpdateSttus(EltgnrSttus eltgnrSttus);

    void eltgnrCreateAlarmHistory(EltgnrAlarmHistory eltgnrAlarmHistory);
    void eltgnrUpdateAlarmHistory(EltgnrAlarmHistory eltgnrAlarmHistory);

    void eltgnrCreateRunHistory(EltgnrRunHistory eltgnrRunHistory);
    void eltgnrUpdateRunHistory(EltgnrRunHistory eltgnrRunHistory);
}
