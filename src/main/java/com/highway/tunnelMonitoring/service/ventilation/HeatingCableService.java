package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.damper.ExhaustDamperRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCable;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.HeatingCableMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeatingCableService implements CrudService<HeatingCable> {


    private final HeatingCableMapper heatingCableMapper;

    @Override
    public Result<HeatingCable> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<HeatingCable> list = heatingCableMapper.heatingCableFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = heatingCableMapper.heatingCableCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public HeatingCable findOne(String jet_pan_no){ return heatingCableMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(HeatingCable heatingCable){
        heatingCableMapper.heatingCableEnroll(heatingCable);
    }

    @Override
    public void update(HeatingCable heatingCable){
        heatingCableMapper.heatingCableUpdate(heatingCable);
    }

    @Override
    public void delete(HeatingCable heatingCable){
        heatingCableMapper.heatingCableDelete(heatingCable);
    }


    public Result<HeatingCableSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<HeatingCableSttus> list = heatingCableMapper.heatingCableMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = heatingCableMapper.heatingCableMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<HeatingCableRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<HeatingCableRunHistory> list = heatingCableMapper.heatingCableRunHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = heatingCableMapper.heatingCableRunCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }


    public Result<HeatingCableAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<HeatingCableAlarmHistory> list = heatingCableMapper.heatingCableAlarmHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = heatingCableMapper.heatingCableAlarmCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
