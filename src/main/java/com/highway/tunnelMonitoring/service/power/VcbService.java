package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.acb.AcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrRunHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.Vcb;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbSttus;
import com.highway.tunnelMonitoring.mapper.power.VcbMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VcbService implements CrudService<Vcb> {

    private final VcbMapper vcbMapper;

    @Override
    public Result<Vcb> findAll(String linkId, int page, int size, String sort_column, String sort_direction) {
        int offset = (page - 1) * size;
        List<Vcb> list = vcbMapper.vcbFindAll(linkId, offset, size);
        int total = vcbMapper.vcbCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Vcb findOne(String vcb_no){ return vcbMapper.findOne(vcb_no); }

    @Override
    public void enroll(Vcb vcb){
        vcbMapper.vcbEnroll(vcb);
    }

    @Override
    public void update(Vcb vcb){
        vcbMapper.vcbUpdate(vcb);
    }

    @Override
    public void delete(Vcb vcb){
        vcbMapper.vcbDelete(vcb);
    }

    public Result<VcbSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<VcbSttus> list = vcbMapper.vcbMonitor(linkId, offset, size);
        int total = vcbMapper.vcbMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
    public Result<VcbAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<VcbAlarmHistory> list = vcbMapper.vcbAlarmHistory(linkId, offset, size, startDate, endDate);
        int total = vcbMapper.vcbAlarmCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<VcbRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<VcbRunHistory> list = vcbMapper.vcbRunHistory(linkId, offset, size, startDate, endDate);
        int total = vcbMapper.vcbRunCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
