package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.swtbrd.Swtbrd;
import com.highway.tunnelMonitoring.domain.power.swtbrd.SwtbrdAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.swtbrd.SwtbrdRunHistory;
import com.highway.tunnelMonitoring.domain.power.swtbrd.SwtbrdSttus;
import com.highway.tunnelMonitoring.domain.power.swtbrd.SwtbrdStat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SwtbrdMapper {
    List<Swtbrd> swtbrdFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int swtbrdCountAll(@Param("link_id") String linkId);
    //데이터 등록
    void swtbrdEnroll(Swtbrd swtbrd);
    //데이터 업데이트
    void swtbrdUpdate(Swtbrd swtbrd);

    //데이터 삭제
    void swtbrdDelete(Swtbrd swtbrd);

    List<SwtbrdSttus> swtbrdMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                    @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int swtbrdMonitorCountAll(@Param("link_id") String linkId);

    int swtbrdAlarmCountAll(@Param("link_id") String linkId);

    List<SwtbrdAlarmHistory> swtbrdAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    List<SwtbrdRunHistory> swtbrdRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int swtbrdRunCountAll(@Param("link_id") String linkId);

    int swtbrdStatCountAll(@Param("link_id") String linkId);

    List<SwtbrdStat> swtbrdStat(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);


    //매 자정 통계 기록
    void swtbrdRecordStat();


    SwtbrdSttus swtbrdFindSttus(@Param("swtbrd_id") String swtbrdId, @Param("link_id") String linkId);


    void SwtbrdUpdateSttus(SwtbrdSttus swtbrdSttus);

    void swtbrdCreateAlarmHistory(SwtbrdAlarmHistory swtbrdAlarmHistory);
    void swtbrdUpdateAlarmHistory(SwtbrdAlarmHistory swtbrdAlarmHistory);

    void swtbrdCreateRunHistory(SwtbrdRunHistory swtbrdRunHistory);
    void swtbrdUpdateRunHistory(SwtbrdRunHistory swtbrdRunHistory);
}
