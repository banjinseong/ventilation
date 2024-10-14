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
    public Result<WaterTank> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<WaterTank> list = waterTankMapper.waterTankFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = waterTankMapper.waterTankCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public WaterTank findOne(String jet_pan_no){ return waterTankMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(WaterTank waterTank){
        waterTankMapper.waterTankEnroll(waterTank);
    }

    @Override
    public void update(WaterTank waterTank){
        waterTankMapper.waterTankUpdate(waterTank);
    }

    @Override
    public void delete(WaterTank waterTank){
        waterTankMapper.waterTankDelete(waterTank);
    }


    public Result<WaterTankSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<WaterTankSttus> list = waterTankMapper.waterTankMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = waterTankMapper.waterTankMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<WaterTankAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<WaterTankAlarmHistory> list = waterTankMapper.waterTankAlarmHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = waterTankMapper.waterTankAlarmCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
