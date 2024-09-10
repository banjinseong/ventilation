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
    public Result<Ups> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Ups> list = upsMapper.findAll(offset, size);
        int total = upsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Ups findOne(String ups_no){ return upsMapper.findOne(ups_no); }

    @Override
    public void enroll(Ups ups){
        upsMapper.enroll(ups);
    }

    @Override
    public void update(Ups ups){
        upsMapper.update(ups);
    }

    @Override
    public void delete(Ups ups){
        upsMapper.delete(ups);
    }

    public Result<UpsSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<UpsSttus> list = upsMapper.monitor(offset, size);
        int total = upsMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<UpsFaultHistory> faultHistory(int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<UpsFaultHistory> list = upsMapper.faultHistory(offset, size, startDate, endDate);
        int total = upsMapper.faultCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<UpsRunHistory> runHistory(int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<UpsRunHistory> list = upsMapper.runHistory(offset, size, startDate, endDate);
        int total = upsMapper.runCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
