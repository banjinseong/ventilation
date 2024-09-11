package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.acb.AcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.acb.AcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.Vcb;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbSttus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface VcbMapper {
    List<Vcb> vcbFindAll(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int limit);

    int vcbCountAll();
    //하나만 조회

    //데이터 등록
    void vcbEnroll(Vcb vcb);
    //데이터 업데이트
    void vcbUpdate(Vcb vcb);

    //데이터 삭제
    void vcbDelete(Vcb vcb);

    List<VcbSttus> vcbMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    List<VcbAlarmHistory> vcbAlarmHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int vcbAlarmCountAll();

    int vcbMonitorCountAll();


    List<VcbRunHistory> vcbRunHistory(@Param("link_id") String linkId, int offset, int size, LocalDateTime startDate, LocalDateTime endDate);

    int vcbRunCountAll();
}
