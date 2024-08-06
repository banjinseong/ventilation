package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.Lght;
import com.highway.tunnelMonitoring.domain.power.Rect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RectMapper {
    
    List<Rect> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    Rect findOne(String rect_no);
    //데이터 등록
    void enroll(Rect rect);
    //데이터 업데이트
    void update(Rect rect);

    //데이터 삭제
    void delete(String rect_no);
}
