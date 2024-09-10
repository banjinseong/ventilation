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
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PumpService implements CrudService<Pump> {

    private final PumpMapper pumpMapper;

    @Override
    public Result<Pump> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Pump> list = pumpMapper.findAll(offset, size);
        int total = pumpMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public Pump findOne(String jet_pan_no){ return pumpMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(Pump pump){
        pumpMapper.enroll(pump);
    }

    @Override
    public void update(Pump pump){
        pumpMapper.update(pump);
    }

    @Override
    public void delete(Pump pump){
        pumpMapper.delete(pump);
    }


    public Result<PumpSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<PumpSttus> list = pumpMapper.monitor(offset, size);
        int total = pumpMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }


    public Result<PumpFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<PumpFaultHistory> list = pumpMapper.faultHistory(linkId, offset, size, startDate, endDate);
        int total = pumpMapper.faultCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<PumpRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<PumpRunHistory> list = pumpMapper.runHistory(linkId, offset, size, startDate, endDate);
        int total = pumpMapper.runCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<PumpStat> stat(String linkId, int page, int size, LocalDate startDate, LocalDate endDate) {
        int offset = (page - 1) * size;
        List<PumpStat> list = pumpMapper.stat(linkId, offset, size, startDate, endDate);
        int total = pumpMapper.statCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
