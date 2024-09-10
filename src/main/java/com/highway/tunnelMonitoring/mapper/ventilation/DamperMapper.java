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
    List<ExhaustDamper> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
//    ExhaustDamper findOne(String cmo_msrins_no);
    //데이터 등록
    void enroll(ExhaustDamper exhaustDamper);
    //데이터 업데이트
    void update(ExhaustDamper exhaustDamper);

    //데이터 삭제
    void delete(ExhaustDamper exhaustDamper);

    List<ExhaustDamperSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

    List<ExhaustDamperRunHistory> runHistory(int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int runCountAll();

    int monitorCountAll();
}
