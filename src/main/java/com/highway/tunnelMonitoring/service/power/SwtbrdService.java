package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.swtbrd.*;
import com.highway.tunnelMonitoring.mapper.power.SwtbrdMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SwtbrdService implements CrudService<Swtbrd> {

    private final SwtbrdMapper swtbrdMapper;

    @Override
    public Result<Swtbrd> findAll(String linkId, int page, int size, String sort_column, String sort_direction) {
        int offset = (page - 1) * size;
        List<Swtbrd> list = swtbrdMapper.swtbrdFindAll(linkId, offset, size);
        int total = swtbrdMapper.swtbrdCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Swtbrd findOne(String swtbrd_no){ return swtbrdMapper.findOne(swtbrd_no); }

    @Override
    public void enroll(Swtbrd swtbrd){
        swtbrdMapper.swtbrdEnroll(swtbrd);
    }

    @Override
    public void update(Swtbrd swtbrd){
        swtbrdMapper.swtbrdUpdate(swtbrd);
    }

    @Override
    public void delete(Swtbrd swtbrd){
        swtbrdMapper.swtbrdDelete(swtbrd);
    }

    public Result<SwtbrdSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<SwtbrdSttus> list = swtbrdMapper.swtbrdMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = swtbrdMapper.swtbrdMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<SwtbrdAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<SwtbrdAlarmHistory> list = swtbrdMapper.swtbrdAlarmHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = swtbrdMapper.swtbrdAlarmCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<SwtbrdRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<SwtbrdRunHistory> list = swtbrdMapper.swtbrdRunHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = swtbrdMapper.swtbrdRunCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<SwtbrdStat> stat(String linkId, int page, int size, LocalDate startDate, LocalDate endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<SwtbrdStat> list = swtbrdMapper.swtbrdStat(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = swtbrdMapper.swtbrdStatCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }


    @Scheduled(cron = "0 0 0 * * *")
    public void swtbrdRecordStat(){
        swtbrdMapper.swtbrdRecordStat();
    }

}
