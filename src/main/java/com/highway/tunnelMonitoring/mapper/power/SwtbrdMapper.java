package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.Swtbrd;
import com.highway.tunnelMonitoring.dto.power.eltgnr.EltgnrMonitorDTO;
import com.highway.tunnelMonitoring.dto.power.swtbrd.SwtbrdDTO;
import com.highway.tunnelMonitoring.dto.power.swtbrd.SwtbrdMonitorDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SwtbrdMapper {
    
    List<Swtbrd> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    Swtbrd findOne(String swtbrd_no);
    //데이터 등록
    void enroll(SwtbrdDTO swtbrd);
    //데이터 업데이트
    void update(SwtbrdDTO swtbrd);

    //데이터 삭제
    void delete(String swtbrd_no);

    List<SwtbrdMonitorDTO> monitor(@Param("offset") int offset, @Param("limit") int size);

}
