package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.*;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.mapper.ventilation.VenAxFnMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VenAxFnService implements CrudService<VenAxFn> {

    private final VenAxFnMapper venAxFnMapper;

    @Override
    public Result<VenAxFn> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<VenAxFn> list = venAxFnMapper.venAxFnFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = venAxFnMapper.venAxFnCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public VenAxFn findOne(String ven_axfn_no){ return venAxFnMapper.findOne(ven_axfn_no); }

    @Override
    @Transactional
    public void enroll(VenAxFn venAxfn){
        venAxFnMapper.venAxFnEnroll(venAxfn);
        venAxFnMapper.venAxFnSttusEnroll(venAxfn.getVen_ax_fn_id(), venAxfn.getLink_id());
    }

    @Override
    @Transactional
    public void update(VenAxFn venAxfn){
        venAxFnMapper.venAxFnUpdate(venAxfn);
    }

    @Override
    @Transactional
    public void delete(VenAxFn venAxfn){
        venAxFnMapper.venAxFnDelete(venAxfn);
    }


    public Result<VenAxFnSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<VenAxFnSttus> list = venAxFnMapper.venAxFnMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = venAxFnMapper.venAxFnMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<VenAxFnFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<VenAxFnFaultHistory> list = venAxFnMapper.venAxFnFaultHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = venAxFnMapper.venAxFnFaultCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<VenAxFnRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<VenAxFnRunHistory> list = venAxFnMapper.venAxFnRunHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = venAxFnMapper.venAxFnRunCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<VenAxFnStat> stat(String linkId, int page, int size, LocalDate startDate, LocalDate endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<VenAxFnStat> list = venAxFnMapper.venAxFnStat(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = venAxFnMapper.venAxFnStatCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void venAxFnRecordStat(){
        venAxFnMapper.venAxFnRecordStat();
    }
}
