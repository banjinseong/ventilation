package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpFaultHistory;
import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpStat;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.*;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.mapper.ventilation.VenAxFnMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VenAxFnService implements CrudService<VenAxFn> {

    private final VenAxFnMapper venAxFnMapper;

    @Override
    public Result<VenAxFn> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<VenAxFn> list = venAxFnMapper.findAll(offset, size);
        int total = venAxFnMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public VenAxFn findOne(String ven_axfn_no){ return venAxFnMapper.findOne(ven_axfn_no); }

    @Override
    public void enroll(VenAxFn venAxfn){
        venAxFnMapper.enroll(venAxfn);
    }

    @Override
    public void update(VenAxFn venAxfn){
        venAxFnMapper.update(venAxfn);
    }

    @Override
    public void delete(VenAxFn venAxfn){
        venAxFnMapper.delete(venAxfn);
    }


    public Result<VenAxFnSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<VenAxFnSttus> list = venAxFnMapper.monitor(offset, size);
        int total = venAxFnMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<VenAxFnFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<VenAxFnFaultHistory> list = venAxFnMapper.faultHistory(linkId, offset, size, startDate, endDate);
        int total = venAxFnMapper.faultCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<VenAxFnRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<VenAxFnRunHistory> list = venAxFnMapper.runHistory(linkId, offset, size, startDate, endDate);
        int total = venAxFnMapper.runCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<VenAxFnStat> stat(String linkId, int page, int size, LocalDate startDate, LocalDate endDate) {
        int offset = (page - 1) * size;
        List<VenAxFnStat> list = venAxFnMapper.stat(linkId, offset, size, startDate, endDate);
        int total = venAxFnMapper.statCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
