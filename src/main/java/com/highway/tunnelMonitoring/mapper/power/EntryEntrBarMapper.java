package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBar;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarFaultHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarRunHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EntryEntrBarMapper {
    
    List<EntryEntrBar> entryEntrBarFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                                           @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int entryEntrBarCountAll(@Param("link_id") String linkId);
    //데이터 등록
    void entryEntrBarEnroll(EntryEntrBar entryEntrBar);
    //데이터 업데이트
    void entryEntrBarUpdate(EntryEntrBar entryEntrBar);

    //데이터 삭제
    void entryEntrBarDelete(EntryEntrBar entryEntrBar);

    List<EntryEntrBarSttus> entryEntrBarMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int entryEntrBarMonitorCountAll(@Param("link_id") String linkId);

    List<EntryEntrBarFaultHistory> entryEntrBarFaultHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                            @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int entryEntrBarFaultCountAll(@Param("link_id") String linkId);


    List<EntryEntrBarRunHistory> entryEntrBarRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                        @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                        @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int entryEntrBarRunCountAll(@Param("link_id") String linkId);

    EntryEntrBarSttus entryEntrBarFindSttus(@Param("entryEntrBar_id") String entryEntrBarId, @Param("link_id") String linkId);

    void EntryEntrBarUpdateSttus(EntryEntrBarSttus entryEntrBarSttus);

    void entryEntrBarCreateFaultHistory(EntryEntrBarFaultHistory entryEntrBarFaultHistory);
    void entryEntrBarUpdateFaultHistory(EntryEntrBarFaultHistory entryEntrBarFaultHistory);

    void entryEntrBarCreateRunHistory(EntryEntrBarRunHistory entryEntrBarRunHistory);
    void entryEntrBarUpdateRunHistory(EntryEntrBarRunHistory entryEntrBarRunHistory);

}
