package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.rect.RectSttus;
import com.highway.tunnelMonitoring.domain.power.ups.Ups;
import com.highway.tunnelMonitoring.domain.power.ups.UpsFaultHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsRunHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UpsMapper {
    
    List<Ups> upsFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                         @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int upsCountAll(@Param("link_id") String linkId);

    //데이터 등록
    void upsEnroll(Ups ups);
    //데이터 업데이트
    void upsUpdate(Ups ups);

    //데이터 삭제
    void upsDelete(Ups ups);

    List<UpsSttus> upsMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                              @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int upsMonitorCountAll(@Param("link_id") String linkId);


    List<UpsFaultHistory> upsFaultHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                          @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                          @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int upsFaultCountAll(@Param("link_id") String linkId,
                         @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    List<UpsRunHistory> upsRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                      @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                      @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int upsRunCountAll(@Param("link_id") String linkId,
                       @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


    UpsSttus upsFindSttus(@Param("ups_id") String upsId, @Param("link_id") String linkId);


    void UpsUpdateSttus(UpsSttus upsSttus);


    void upsCreateFaultHistory(UpsFaultHistory upsFaultHistory);
    void upsUpdateFaultHistory(UpsFaultHistory upsFaultHistory);

    void upsCreateRunHistory(UpsRunHistory upsRunHistory);
    void upsUpdateRunHistory(UpsRunHistory upsRunHistory);
}
