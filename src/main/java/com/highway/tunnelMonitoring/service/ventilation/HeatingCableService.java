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
    public Result<HeatingCable> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<HeatingCable> list = heatingCableMapper.findAll(offset, size);
        int total = heatingCableMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public HeatingCable findOne(String jet_pan_no){ return heatingCableMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(HeatingCable heatingCable){
        heatingCableMapper.enroll(heatingCable);
    }

    @Override
    public void update(HeatingCable heatingCable){
        heatingCableMapper.update(heatingCable);
    }

    @Override
    public void delete(HeatingCable heatingCable){
        heatingCableMapper.delete(heatingCable);
    }


    public Result<HeatingCableSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<HeatingCableSttus> list = heatingCableMapper.monitor(offset, size);
        int total = heatingCableMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<HeatingCableRunHistory> runHistory(int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<HeatingCableRunHistory> list = heatingCableMapper.runHistory(offset, size, startDate, endDate);
        int total = heatingCableMapper.runCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }


    public Result<HeatingCableAlarmHistory> alarmHistory(int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<HeatingCableAlarmHistory> list = heatingCableMapper.alarmHistory(offset, size, startDate, endDate);
        int total = heatingCableMapper.alarmCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
