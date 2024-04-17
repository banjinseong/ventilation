package com.highway.ventilation.mapper;

import com.highway.ventilation.domain.RefgePouVO;
import com.highway.ventilation.dto.RefgePouGetDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefgePouMapper {
    //모든 조회
    List<RefgePouVO> findAll();
    //하나만 조회
    RefgePouVO findOne(String pou_no);
    //데이터 등록
    void enroll(RefgePouGetDTO refgePouGetDTO);
    //데이터 업데이트
    void update(RefgePouGetDTO refgePouGetDTO);

    //데이터 삭제
    void delete(String pou_no);
}
