package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxfn;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxfnSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VenAxfnMapper {
    
    List<VenAxfn> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    VenAxfn findOne(String ven_axfn_no);
    //데이터 등록
    void enroll(VenAxfn venAxfn);
    //데이터 업데이트
    void update(VenAxfn venAxfn);

    //데이터 삭제
    void delete(String ven_axfn_no);

    List<VenAxfnSttus> monitor(@Param("offset") int offset, @Param("limit") int size);

}
