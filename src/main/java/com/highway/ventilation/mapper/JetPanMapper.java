package com.highway.ventilation.mapper;

import com.highway.ventilation.domain.jetpan.JetPan;
import com.highway.ventilation.dto.JetPanGetDTO;
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
    void enroll(JetPanGetDTO jetPanGetDTO);
    //데이터 업데이트
    void update(JetPanGetDTO jetPanGetDTO);

    //데이터 삭제
    void delete(String jet_pan_no);
}
