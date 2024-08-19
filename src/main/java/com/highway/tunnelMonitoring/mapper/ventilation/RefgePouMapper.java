package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePou;
import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePouSttus;
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
    void enroll(RefgePou refgePou);
    //데이터 업데이트
    void update(RefgePou refgePou);

    //데이터 삭제
    void delete(RefgePou refgePou);

    List<RefgePouSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
