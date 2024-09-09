package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxFn;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxFnSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VenAxFnMapper {
    
    List<VenAxFn> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    VenAxFn findOne(String ven_axfn_no);
    //데이터 등록
    void enroll(VenAxFn venAxfn);
    //데이터 업데이트
    void update(VenAxFn venAxfn);

    //데이터 삭제
    void delete(VenAxFn venAxfn);

    List<VenAxFnSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
