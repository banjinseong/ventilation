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
    public Result<TempHum> findAll(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<TempHum> list = tempHumMapper.tempHumFindAll(linkId, offset, size);
        int total = tempHumMapper.tempHumCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public TempHum findOne(String jet_pan_no){ return tempHumMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(TempHum tempHum){
        tempHumMapper.tempHumEnroll(tempHum);
    }

    @Override
    public void update(TempHum tempHum){
        tempHumMapper.tempHumUpdate(tempHum);
    }

    @Override
    public void delete(TempHum tempHum){
        tempHumMapper.tempHumDelete(tempHum);
    }


    public Result<TempHumSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<TempHumSttus> list = tempHumMapper.tempHumMonitor(linkId, offset, size);
        int total = tempHumMapper.tempHumCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    /**
     * 현재 상태 기록
     */
    public void currentSttus(TempHumSttus tempHumSttus){


    }
}
