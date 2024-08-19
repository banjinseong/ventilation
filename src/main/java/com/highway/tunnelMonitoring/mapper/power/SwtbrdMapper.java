package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.swtbrd.Swtbrd;
import com.highway.tunnelMonitoring.domain.power.swtbrd.SwtbrdSttus;
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
    void enroll(Swtbrd swtbrd);
    //데이터 업데이트
    void update(Swtbrd swtbrd);

    //데이터 삭제
    void delete(Swtbrd swtbrd);

    List<SwtbrdSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
