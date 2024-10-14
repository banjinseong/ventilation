package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.lght.Lght;
import com.highway.tunnelMonitoring.domain.power.lght.LghtSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface LghtMapper {
    List<Lght> lghtFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int lghtCountAll(@Param("link_id") String linkId);
    //데이터 등록
    void lghtEnroll(Lght lght);
    //데이터 업데이트
    void lghtUpdate(Lght lght);

    //데이터 삭제
    void lghtDelete(Lght lght);

    List<LghtSttus> lghtMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size,
                                    @Param("sort_column") String sortColumn, @Param("sort_direction") String sortDirection);

    int lghtMonitorCountAll(@Param("link_id") String linkId);


    LghtSttus lghtFindSttus(@Param("lght_id") String lghtId, @Param("link_id") String linkId);


    void LghtUpdateSttus(LghtSttus lghtSttus);

}
