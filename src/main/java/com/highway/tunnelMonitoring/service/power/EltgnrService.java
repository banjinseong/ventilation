package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.acb.AcbRunHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.Eltgnr;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrRunHistory;
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
    public Result<Eltgnr> findAll(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<Eltgnr> list = eltgnrMapper.eltgnrFindAll(linkId, offset, size);
        int total = eltgnrMapper.eltgnrCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Eltgnr findOne(String eltgnr_no){ return eltgnrMapper.findOne(eltgnr_no); }

    @Override
    public void enroll(Eltgnr eltgnr){
        eltgnrMapper.eltgnrEnroll(eltgnr);
    }

    @Override
    public void update(Eltgnr eltgnr){
        eltgnrMapper.eltgnrUpdate(eltgnr);
    }

    @Override
    public void delete(Eltgnr eltgnr){
        eltgnrMapper.eltgnrDelete(eltgnr);
    }

    public Result<EltgnrSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<EltgnrSttus> list = eltgnrMapper.eltgnrMonitor(linkId, offset, size);
        int total = eltgnrMapper.eltgnrMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<EltgnrAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<EltgnrAlarmHistory> list = eltgnrMapper.eltgnrAlarmHistory(linkId, offset, size, startDate, endDate);
        int total = eltgnrMapper.eltgnrAlarmCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<EltgnrRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<EltgnrRunHistory> list = eltgnrMapper.eltgnrRunHistory(linkId, offset, size, startDate, endDate);
        int total = eltgnrMapper.eltgnrRunCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

}
