package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.lght.Lght;
import com.highway.tunnelMonitoring.domain.power.lght.LghtSttus;
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
    void enroll(Lght lght);
    //데이터 업데이트
    void update(Lght lght);

    //데이터 삭제
    void delete(Lght lght);

    List<LghtSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
