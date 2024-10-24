package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCable;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableSttus;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanFaultHistory;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanStat;
import com.highway.tunnelMonitoring.domain.ventilation.pump.*;
import com.highway.tunnelMonitoring.mapper.ventilation.HeatingCableMapper;
import com.highway.tunnelMonitoring.mapper.ventilation.PumpMapper;
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
public class PumpService implements CrudService<Pump> {

    private final PumpMapper pumpMapper;

    @Override
    public Result<Pump> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<Pump> list = pumpMapper.pumpFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = pumpMapper.pumpCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public Pump findOne(String jet_pan_no){ return pumpMapper.findOne(jet_pan_no); }

    @Override
    @Transactional
    public void enroll(Pump pump){
        pumpMapper.pumpEnroll(pump);
        pumpMapper.pumpSttusEnroll(pump.getPump_id(), pump.getLink_id());
    }

    @Override
    @Transactional
    public void update(Pump pump){
        pumpMapper.pumpUpdate(pump);
    }

    @Override
    @Transactional
    public void delete(Pump pump){
        pumpMapper.pumpDelete(pump);
    }


    public Result<PumpSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<PumpSttus> list = pumpMapper.pumpMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = pumpMapper.pumpMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }


    public Result<PumpFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<PumpFaultHistory> list = pumpMapper.pumpFaultHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = pumpMapper.pumpFaultCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<PumpRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<PumpRunHistory> list = pumpMapper.pumpRunHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = pumpMapper.pumpRunCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<PumpStat> stat(String linkId, int page, int size, LocalDate startDate, LocalDate endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<PumpStat> list = pumpMapper.pumpStat(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = pumpMapper.pumpStatCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void pumpRecordStat(){
        pumpMapper.pumpRecordStat();
    }
}
