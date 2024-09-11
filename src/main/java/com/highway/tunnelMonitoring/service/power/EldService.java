package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eld.Eld;
import com.highway.tunnelMonitoring.domain.power.eld.EldAlarmHistroy;
import com.highway.tunnelMonitoring.domain.power.eld.EldSttus;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbAlarmHistory;
import com.highway.tunnelMonitoring.mapper.power.EldMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EldService implements CrudService<Eld> {


    private final EldMapper eldMapper;

    @Override
    public Result<Eld> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Eld> list = eldMapper.findAll(offset, size);
        int total = eldMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Eld findOne(String eld_no){ return eldMapper.findOne(eld_no); }

    @Override
    public void enroll(Eld eld){
        eldMapper.enroll(eld);
    }

    @Override
    public void update(Eld eld){
        eldMapper.update(eld);
    }

    @Override
    public void delete(Eld eld){
        eldMapper.delete(eld);
    }

    public Result<EldSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<EldSttus> list = eldMapper.monitor(offset, size);
        int total = eldMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<EldAlarmHistroy> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<EldAlarmHistroy> list = eldMapper.alarmHistory(linkId, offset, size, startDate, endDate);
        int total = eldMapper.alarmCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
