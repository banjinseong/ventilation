package com.highway.tunnelMonitoring.mapper.power;

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
    
    List<Ups> upsFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int upsCountAll(@Param("link_id") String linkId);

    //데이터 등록
    void upsEnroll(Ups ups);
    //데이터 업데이트
    void upsUpdate(Ups ups);

    //데이터 삭제
    void upsDelete(Ups ups);

    List<UpsSttus> upsMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    int upsMonitorCountAll(@Param("link_id") String linkId);


    List<UpsFaultHistory> upsFaultHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int upsFaultCountAll(@Param("link_id") String linkId);

    List<UpsRunHistory> upsRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int upsRunCountAll(@Param("link_id") String linkId);
}
