package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.acb.Acb;
import com.highway.tunnelMonitoring.domain.power.acb.AcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.acb.AcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.acb.AcbSttus;

import com.highway.tunnelMonitoring.domain.power.ups.UpsRunHistory;
import com.highway.tunnelMonitoring.mapper.power.AcbMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcbService implements CrudService<Acb> {


    private final AcbMapper acbMapper;

    @Override
    public Result<Acb> findAll(String linkId, int page, int size, String sort_column, String sort_direction) {
        int offset = (page - 1) * size;
        List<Acb> list = acbMapper.acbFindAll(linkId, offset, size);
        int total = acbMapper.acbCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Acb findOne(String acb_no){ return acbMapper.findOne(acb_no); }

    @Override
    public void enroll(Acb acb){
        acbMapper.acbEnroll(acb);
    }

    @Override
    public void update(Acb acb){
        acbMapper.acbUpdate(acb);
    }

    @Override
    public void delete(Acb acb){
        acbMapper.acbDelete(acb);
    }

    public Result<AcbSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<AcbSttus> list = acbMapper.acbMonitor(linkId, offset, size);
        System.out.println(list);
        int total = acbMapper.acbMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<AcbAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<AcbAlarmHistory> list = acbMapper.acbAlarmHistory(linkId, offset, size, startDate, endDate);
        int total = acbMapper.acbAlarmCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<AcbRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<AcbRunHistory> list = acbMapper.acbRunHistory(linkId, offset, size, startDate, endDate);
        int total = acbMapper.acbRunCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
