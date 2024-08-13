package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePou;
import com.highway.tunnelMonitoring.dto.ventilation.cmomsrins.CmoMsrinsMonitorDTO;
import com.highway.tunnelMonitoring.dto.ventilation.refgepou.RefgePouGetDTO;
import com.highway.tunnelMonitoring.dto.ventilation.refgepou.RefgePouMonitorDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RefgePouMapper {

    List<RefgePou> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    RefgePou findOne(String pou_no);
    //데이터 등록
    void enroll(RefgePouGetDTO refgePouGetDTO);
    //데이터 업데이트
    void update(RefgePouGetDTO refgePouGetDTO);

    //데이터 삭제
    void delete(String pou_no);

    List<RefgePouMonitorDTO> monitor(@Param("offset") int offset, @Param("limit") int size);

}
