package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.Result;

import com.highway.tunnelMonitoring.domain.ventilation.fire.FireAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.fire.FireStat;
import com.highway.tunnelMonitoring.domain.ventilation.fire.FireSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.FireMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FireService {
    private final FireMapper fireMapper;

    public Result<FireSttus> monitor(int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<FireSttus> list = fireMapper.fireMonitor(offset, size, sortColumn, sortDirection);
        int total = fireMapper.fireMonitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<FireAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<FireAlarmHistory> list = fireMapper.fireAlarmHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = fireMapper.fireAlarmCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
    public Result<FireStat> stat(int page, int size, LocalDate startDate, LocalDate endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<FireStat> list = fireMapper.fireStat(offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = fireMapper.fireStatCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }


    @Scheduled(cron = "0 0 0 * * *")
    public void fireRecordStat(){
        fireMapper.fireRecordStat();
    }

}
