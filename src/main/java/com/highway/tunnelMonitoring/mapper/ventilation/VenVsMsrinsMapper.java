package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venmsrins.VenVsMsrins;
import com.highway.tunnelMonitoring.domain.ventilation.venmsrins.VenVsSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VenVsMsrinsMapper {
    
    List<VenVsMsrins> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    VenVsMsrins findOne(String ven_vs_msrins_no);
    //데이터 등록
    void enroll(VenVsMsrins venVsMsrins);
    //데이터 업데이트
    void update(VenVsMsrins venVsMsrins);

    //데이터 삭제
    void delete(VenVsMsrins venVsMsrins);

    List<VenVsSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
