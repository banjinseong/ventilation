package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.Lght;
import com.highway.tunnelMonitoring.dto.power.eltgnr.EltgnrMonitorDTO;
import com.highway.tunnelMonitoring.dto.power.lght.LghtDTO;
import com.highway.tunnelMonitoring.dto.power.lght.LghtMonitorDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LghtMapper {
    
    List<Lght> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    Lght findOne(String lght_group_no, String lght_knd);
    //데이터 등록
    void enroll(LghtDTO lght);
    //데이터 업데이트
    void update(LghtDTO lght);

    //데이터 삭제
    void delete(String lght_group_no, String lght_knd);

    List<LghtMonitorDTO> monitor(@Param("offset") int offset, @Param("limit") int size);

}
