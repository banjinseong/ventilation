package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.ups.Ups;
import com.highway.tunnelMonitoring.domain.power.ups.UpsSttus;
import com.highway.tunnelMonitoring.mapper.power.UpsMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpsService implements CrudService<Ups, String> {

    private final UpsMapper upsMapper;

    @Override
    public Result<Ups> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Ups> list = upsMapper.findAll(offset, size);
        int total = upsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    @Override
    public Ups findOne(String ups_no){ return upsMapper.findOne(ups_no); }

    @Override
    public void enroll(Ups ups){
        upsMapper.enroll(ups);
    }

    @Override
    public void update(Ups ups){
        upsMapper.update(ups);
    }

    @Override
    public void delete(String ups_no){
        upsMapper.delete(ups_no);
    }

    public Result<UpsSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<UpsSttus> list = upsMapper.monitor(offset, size);
        int total = upsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
