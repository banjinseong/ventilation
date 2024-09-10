package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCable;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableSttus;
import com.highway.tunnelMonitoring.domain.ventilation.temphum.TempHum;
import com.highway.tunnelMonitoring.domain.ventilation.temphum.TempHumSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.HeatingCableMapper;
import com.highway.tunnelMonitoring.mapper.ventilation.TempHumMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TempHumService implements CrudService<TempHum> {

    private final TempHumMapper tempHumMapper;

    @Override
    public Result<TempHum> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<TempHum> list = tempHumMapper.findAll(offset, size);
        int total = tempHumMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public TempHum findOne(String jet_pan_no){ return tempHumMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(TempHum tempHum){
        tempHumMapper.enroll(tempHum);
    }

    @Override
    public void update(TempHum tempHum){
        tempHumMapper.update(tempHum);
    }

    @Override
    public void delete(TempHum tempHum){
        tempHumMapper.delete(tempHum);
    }


    public Result<TempHumSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<TempHumSttus> list = tempHumMapper.monitor(offset, size);
        int total = tempHumMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    /**
     * 현재 상태 기록
     */
    public void currentSttus(TempHumSttus tempHumSttus){


    }
}
