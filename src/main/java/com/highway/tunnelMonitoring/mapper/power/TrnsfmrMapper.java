package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.trnsfmr.Trnsfmr;
import com.highway.tunnelMonitoring.domain.power.trnsfmr.TrnsfmrSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TrnsfmrMapper {
    
    List<Trnsfmr> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    Trnsfmr findOne(String trnsfmr_no);
    //데이터 등록
    void enroll(Trnsfmr trnsfmr);
    //데이터 업데이트
    void update(Trnsfmr trnsfmr);

    //데이터 삭제
    void delete(Trnsfmr trnsfmr);

    List<TrnsfmrSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
