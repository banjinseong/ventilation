package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.Ups;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.power.eltgnr.EltgnrMonitorDTO;
import com.highway.tunnelMonitoring.dto.power.ups.UpsDTO;
import com.highway.tunnelMonitoring.dto.power.ups.UpsMonitorDTO;
import com.highway.tunnelMonitoring.mapper.power.UpsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpsService {

    private final UpsMapper upsMapper;

    public Result<Ups> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Ups> list = upsMapper.findAll(offset, size);
        int total = upsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Ups findOne(String ups_no){ return upsMapper.findOne(ups_no); }

    public void enroll(UpsDTO upsDTO){
        upsMapper.enroll(upsDTO);
    }

    public void update(UpsDTO upsDTO){
        upsMapper.update(upsDTO);
    }

    public void delete(String ups_no){
        upsMapper.delete(ups_no);
    }

    public Result<UpsMonitorDTO> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<UpsMonitorDTO> list = upsMapper.monitor(offset, size);
        int total = upsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
