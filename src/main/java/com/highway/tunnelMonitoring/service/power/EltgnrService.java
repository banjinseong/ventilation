package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.Eltgnr;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrSttus;
import com.highway.tunnelMonitoring.mapper.power.EltgnrMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EltgnrService implements CrudService<Eltgnr> {

    private final EltgnrMapper eltgnrMapper;

    @Override
    public Result<Eltgnr> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Eltgnr> list = eltgnrMapper.findAll(offset, size);
        int total = eltgnrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Eltgnr findOne(String eltgnr_no){ return eltgnrMapper.findOne(eltgnr_no); }

    @Override
    public void enroll(Eltgnr eltgnr){
        eltgnrMapper.enroll(eltgnr);
    }

    @Override
    public void update(Eltgnr eltgnr){
        eltgnrMapper.update(eltgnr);
    }

    @Override
    public void delete(Eltgnr eltgnr){
        eltgnrMapper.delete(eltgnr);
    }

    public Result<EltgnrSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<EltgnrSttus> list = eltgnrMapper.monitor(offset, size);
        int total = eltgnrMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<EltgnrAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<EltgnrAlarmHistory> list = eltgnrMapper.alarmHistory(linkId, offset, size, startDate, endDate);
        int total = eltgnrMapper.alarmCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
