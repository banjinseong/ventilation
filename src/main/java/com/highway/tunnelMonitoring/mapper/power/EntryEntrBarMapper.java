package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBar;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarFaultHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarRunHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarSttus;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbAlarmHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EntryEntrBarMapper {
    
    List<EntryEntrBar> entryEntrBarFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int entryEntrBarCountAll(@Param("link_id") String linkId);
    //데이터 등록
    void entryEntrBarEnroll(EntryEntrBar entryEntrBar);
    //데이터 업데이트
    void entryEntrBarUpdate(EntryEntrBar entryEntrBar);

    //데이터 삭제
    void entryEntrBarDelete(EntryEntrBar entryEntrBar);

    List<EntryEntrBarSttus> entryEntrBarMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int entryEntrBarMonitorCountAll(@Param("link_id") String linkId);

    List<EntryEntrBarFaultHistory> entryEntrBarFaultHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int entryEntrBarFaultCountAll(@Param("link_id") String linkId);


    List<EntryEntrBarRunHistory> entryEntrBarRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int entryEntrBarRunCountAll(@Param("link_id") String linkId);

}
