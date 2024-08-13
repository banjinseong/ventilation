package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.PowPop;
import com.highway.tunnelMonitoring.dto.power.eltgnr.EltgnrMonitorDTO;
import com.highway.tunnelMonitoring.dto.power.powpop.PowPopDTO;
import com.highway.tunnelMonitoring.dto.power.powpop.PowPopMonitorDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PowPopMapper {
    
    List<PowPop> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    PowPop findOne(String pow_pop_no);
    //데이터 등록
    void enroll(PowPopDTO powPop);
    //데이터 업데이트
    void update(PowPopDTO powPop);

    //데이터 삭제
    void delete(String pow_pop_no);

    List<PowPopMonitorDTO> monitor(@Param("offset") int offset, @Param("limit") int size);

}
