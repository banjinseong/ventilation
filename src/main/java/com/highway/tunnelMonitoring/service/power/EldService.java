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
    public Result<Eld> findAll(String linkId, int page, int size, String sort_column, String sort_direction) {
        int offset = (page - 1) * size;
        List<Eld> list = eldMapper.eldFindAll(linkId, offset, size);
        int total = eldMapper.eldCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Eld findOne(String eld_no){ return eldMapper.findOne(eld_no); }

    @Override
    public void enroll(Eld eld){
        eldMapper.eldEnroll(eld);
    }

    @Override
    public void update(Eld eld){
        eldMapper.eldUpdate(eld);
    }

    @Override
    public void delete(Eld eld){
        eldMapper.eldDelete(eld);
    }

    public Result<EldSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<EldSttus> list = eldMapper.eldMonitor(linkId, offset, size);
        int total = eldMapper.eldMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<EldAlarmHistroy> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<EldAlarmHistroy> list = eldMapper.eldAlarmHistory(linkId, offset, size, startDate, endDate);
        int total = eldMapper.eldAlarmCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
