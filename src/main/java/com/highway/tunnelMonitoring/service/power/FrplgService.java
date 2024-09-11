package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eld.EldAlarmHistroy;
import com.highway.tunnelMonitoring.domain.power.frplg.Frplg;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgSttus;
import com.highway.tunnelMonitoring.mapper.power.FrplgMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FrplgService implements CrudService<Frplg> {

    private final FrplgMapper frplgMapper;

    @Override
    public Result<Frplg> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Frplg> list = frplgMapper.findAll(offset, size);
        int total = frplgMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Frplg findOne(String frplg_no){ return frplgMapper.findOne(frplg_no); }

    @Override
    public void enroll(Frplg frplg){
        frplgMapper.enroll(frplg);
    }

    @Override
    public void update(Frplg frplg){
        frplgMapper.update(frplg);
    }

    @Override
    public void delete(Frplg frplg){
        frplgMapper.delete(frplg);
    }

    public Result<FrplgSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<FrplgSttus> list = frplgMapper.monitor(offset, size);
        int total = frplgMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<FrplgAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<FrplgAlarmHistory> list = frplgMapper.alarmHistory(linkId, offset, size, startDate, endDate);
        int total = frplgMapper.alarmCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
