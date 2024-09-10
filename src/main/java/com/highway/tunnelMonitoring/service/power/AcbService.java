package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.acb.Acb;
import com.highway.tunnelMonitoring.domain.power.acb.AcbAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.acb.AcbSttus;

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
    public Result<Acb> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Acb> list = acbMapper.findAll(offset, size);
        int total = acbMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Acb findOne(String acb_no){ return acbMapper.findOne(acb_no); }

    @Override
    public void enroll(Acb acb){
        acbMapper.enroll(acb);
    }

    @Override
    public void update(Acb acb){
        acbMapper.update(acb);
    }

    @Override
    public void delete(Acb acb){
        acbMapper.delete(acb);
    }

    public Result<AcbSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<AcbSttus> list = acbMapper.monitor(offset, size);
        int total = acbMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<AcbAlarmHistory> alarmHistory(int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<AcbAlarmHistory> list = acbMapper.alarmHistory(offset, size, startDate, endDate);
        int total = acbMapper.alarmCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
