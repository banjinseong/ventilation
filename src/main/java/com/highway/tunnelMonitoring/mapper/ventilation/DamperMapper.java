package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.damper.ExhaustDamper;
import com.highway.tunnelMonitoring.domain.ventilation.damper.ExhaustDamperRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.damper.ExhaustDamperSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DamperMapper {
    List<ExhaustDamper> damperFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit,
                                      @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int damperCountAll(@Param("link_id") String linkId);
    //하나만 조회
//    ExhaustDamper findOne(String cmo_msrins_no);
    //데이터 등록
    void damperEnroll(ExhaustDamper exhaustDamper);
    //데이터 업데이트
    void damperUpdate(ExhaustDamper exhaustDamper);

    //데이터 삭제
    void damperDelete(ExhaustDamper exhaustDamper);

    List<ExhaustDamperSttus> damperMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                           @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    List<ExhaustDamperRunHistory> damperRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                                   @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                                                   @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int damperRunCountAll(@Param("link_id") String linkId);

    int damperMonitorCountAll(@Param("link_id") String linkId);


    ExhaustDamperSttus damperFindSttus(@Param("damper_id") String damperId, @Param("link_id") String linkId);


    void damperUpdateSttus(ExhaustDamperSttus exhaustDamperSttus);

    void damperCreateRunHistory(ExhaustDamperRunHistory exhaustDamperRunHistory);
    void damperUpdateRunHistory(ExhaustDamperRunHistory exhaustDamperRunHistory);
}
