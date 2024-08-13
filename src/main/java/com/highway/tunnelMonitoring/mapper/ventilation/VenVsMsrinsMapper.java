package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venmsrins.VenVsMsrins;
import com.highway.tunnelMonitoring.dto.ventilation.cmomsrins.CmoMsrinsMonitorDTO;
import com.highway.tunnelMonitoring.dto.ventilation.venvsmsrins.VenVsMsrinsGetDTO;
import com.highway.tunnelMonitoring.dto.ventilation.venvsmsrins.VenVsMsrinsMonitorDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VenVsMsrinsMapper {
    
    List<VenVsMsrins> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    VenVsMsrins findOne(String ven_vs_msrins_no);
    //데이터 등록
    void enroll(VenVsMsrinsGetDTO venVsMsrinsGetDTO);
    //데이터 업데이트
    void update(VenVsMsrinsGetDTO venVsMsrinsGetDTO);

    //데이터 삭제
    void delete(String ven_vs_msrins_no);

    List<VenVsMsrinsMonitorDTO> monitor(@Param("offset") int offset, @Param("limit") int size);

}
