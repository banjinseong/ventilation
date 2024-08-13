package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.Lmtr;
import com.highway.tunnelMonitoring.dto.power.lmtr.LmtrDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LmtrMapper {
    
    List<Lmtr> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    Lmtr findOne(String lmtr_no);
    //데이터 등록
    void enroll(LmtrDTO lmtr);
    //데이터 업데이트
    void update(LmtrDTO lmtr);

    //데이터 삭제
    void delete(String lmtr_no);
}
