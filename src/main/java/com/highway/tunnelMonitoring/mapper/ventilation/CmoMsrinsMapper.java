package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.CO.CmoMsrins;
import com.highway.tunnelMonitoring.domain.ventilation.CO.CmoSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CmoMsrinsMapper {
    
    List<CmoMsrins> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
//    CmoMsrins findOne(String cmo_msrins_no);
    //데이터 등록
    void enroll(CmoMsrins cmoMsrins);
    //데이터 업데이트
    void update(CmoMsrins cmoMsrins);

    //데이터 삭제
    void delete(CmoMsrins cmoMsrins);

    List<CmoSttus> monitor(@Param("offset") int offset, @Param("limit") int size);
}
