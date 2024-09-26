package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpFaultHistory;
import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpStat;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.*;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.mapper.ventilation.VenAxFnMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VenAxFnService implements CrudService<VenAxFn> {

    private final VenAxFnMapper venAxFnMapper;

    @Override
    public Result<VenAxFn> findAll(String linkId, int page, int size, String sort_column, String sort_direction) {
        int offset = (page - 1) * size;
        List<VenAxFn> list = venAxFnMapper.venAxFnFindAll(linkId, offset, size);
        int total = venAxFnMapper.venAxFnCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public VenAxFn findOne(String ven_axfn_no){ return venAxFnMapper.findOne(ven_axfn_no); }

    @Override
    public void enroll(VenAxFn venAxfn){
        venAxFnMapper.venAxFnEnroll(venAxfn);
    }

    @Override
    public void update(VenAxFn venAxfn){
        venAxFnMapper.venAxFnUpdate(venAxfn);
    }

    @Override
    public void delete(VenAxFn venAxfn){
        venAxFnMapper.venAxFnDelete(venAxfn);
    }


    public Result<VenAxFnSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<VenAxFnSttus> list = venAxFnMapper.venAxFnMonitor(linkId, offset, size);
        int total = venAxFnMapper.venAxFnMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<VenAxFnFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<VenAxFnFaultHistory> list = venAxFnMapper.venAxFnFaultHistory(linkId, offset, size, startDate, endDate);
        int total = venAxFnMapper.venAxFnFaultCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<VenAxFnRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<VenAxFnRunHistory> list = venAxFnMapper.venAxFnRunHistory(linkId, offset, size, startDate, endDate);
        int total = venAxFnMapper.venAxFnRunCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<VenAxFnStat> stat(String linkId, int page, int size, LocalDate startDate, LocalDate endDate) {
        int offset = (page - 1) * size;
        List<VenAxFnStat> list = venAxFnMapper.venAxFnStat(linkId, offset, size, startDate, endDate);
        int total = venAxFnMapper.venAxFnStatCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    @Scheduled(cron = "0 0 0 * * *")
    public void venAxFnRecordStat(){
        venAxFnMapper.venAxFnRecordStat();
    }
}
