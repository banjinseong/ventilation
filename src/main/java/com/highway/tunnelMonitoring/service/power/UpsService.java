package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.ups.Ups;
import com.highway.tunnelMonitoring.domain.power.ups.UpsFaultHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsRunHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsSttus;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbAlarmHistory;
import com.highway.tunnelMonitoring.mapper.power.UpsMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpsService implements CrudService<Ups> {

    private final UpsMapper upsMapper;

    @Override
    public Result<Ups> findAll(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<Ups> list = upsMapper.upsFindAll(linkId, offset, size);
        int total = upsMapper.upsCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Ups findOne(String ups_no){ return upsMapper.findOne(ups_no); }

    @Override
    public void enroll(Ups ups){
        upsMapper.upsEnroll(ups);
    }

    @Override
    public void update(Ups ups){
        upsMapper.upsUpdate(ups);
    }

    @Override
    public void delete(Ups ups){
        upsMapper.upsDelete(ups);
    }

    public Result<UpsSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<UpsSttus> list = upsMapper.upsMonitor(linkId, offset, size);
        int total = upsMapper.upsMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<UpsFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<UpsFaultHistory> list = upsMapper.upsFaultHistory(linkId, offset, size, startDate, endDate);
        int total = upsMapper.upsFaultCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<UpsRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<UpsRunHistory> list = upsMapper.upsRunHistory(linkId, offset, size, startDate, endDate);
        int total = upsMapper.upsRunCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
