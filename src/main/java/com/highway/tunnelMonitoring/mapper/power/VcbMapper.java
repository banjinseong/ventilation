package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.acb.AcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.acb.AcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsSttus;
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

    int vcbCountAll(@Param("link_id") String linkId);
    //하나만 조회

    //데이터 등록
    void vcbEnroll(Vcb vcb);
    //데이터 업데이트
    void vcbUpdate(Vcb vcb);

    //데이터 삭제
    void vcbDelete(Vcb vcb);

    List<VcbSttus> vcbMonitor(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size);

    List<VcbAlarmHistory> vcbAlarmHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int vcbAlarmCountAll(@Param("link_id") String linkId);

    int vcbMonitorCountAll(@Param("link_id") String linkId);


    List<VcbRunHistory> vcbRunHistory(@Param("link_id") String linkId, @Param("offset") int offset, @Param("limit") int size, LocalDateTime startDate, LocalDateTime endDate);

    int vcbRunCountAll(@Param("link_id") String linkId);



    VcbSttus vcbFindSttus(@Param("vcb_id") String vcbId, @Param("link_id") String linkId);


    void vcbUpdateSttus(VcbSttus vcbSttus);

    void vcbCreateAlarmHistory(VcbAlarmHistory vcbAlarmHistory);
    void vcbUpdateAlarmHistory(VcbAlarmHistory vcbAlarmHistory);


    void vcbCreateRunHistory(VcbRunHistory vcbRunHistory);
    void vcbUpdateRunHistory(VcbRunHistory vcbRunHistory);
}
