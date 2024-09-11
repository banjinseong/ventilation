package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTank;
import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTankAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.watertank.WaterTankSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.WaterTankMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WaterTankService implements CrudService<WaterTank> {

    private final WaterTankMapper waterTankMapper;

    @Override
    public Result<WaterTank> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<WaterTank> list = waterTankMapper.findAll(offset, size);
        int total = waterTankMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public WaterTank findOne(String jet_pan_no){ return waterTankMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(WaterTank waterTank){
        waterTankMapper.enroll(waterTank);
    }

    @Override
    public void update(WaterTank waterTank){
        waterTankMapper.update(waterTank);
    }

    @Override
    public void delete(WaterTank waterTank){
        waterTankMapper.delete(waterTank);
    }


    public Result<WaterTankSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<WaterTankSttus> list = waterTankMapper.monitor(offset, size);
        int total = waterTankMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<WaterTankAlarmHistory> alarmHistory(String linkID, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<WaterTankAlarmHistory> list = waterTankMapper.alarmHistory(linkID, offset, size, startDate, endDate);
        int total = waterTankMapper.alarmCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
