package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
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
    public Result<Frplg> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<Frplg> list = frplgMapper.frplgFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = frplgMapper.frplgCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Frplg findOne(String frplg_no){ return frplgMapper.findOne(frplg_no); }

    @Override
    public void enroll(Frplg frplg){
        frplgMapper.frplgEnroll(frplg);
    }

    @Override
    public void update(Frplg frplg){
        frplgMapper.frplgUpdate(frplg);
    }

    @Override
    public void delete(Frplg frplg){
        frplgMapper.frplgDelete(frplg);
    }

    public Result<FrplgSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<FrplgSttus> list = frplgMapper.frplgMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = frplgMapper.frplgMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<FrplgAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<FrplgAlarmHistory> list = frplgMapper.frplgAlarmHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = frplgMapper.frplgAlarmCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
