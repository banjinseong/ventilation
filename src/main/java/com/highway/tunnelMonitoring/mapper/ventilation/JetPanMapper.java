package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPan;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JetPanMapper {
    
    List<JetPan> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    JetPan findOne(String jet_pan_no);
    //데이터 등록
    void enroll(JetPan jetPanGetDTO);
    //데이터 업데이트
    void update(JetPan jetPanGetDTO);

    //데이터 삭제
    void delete(String jet_pan_no);

    List<JetPanSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
