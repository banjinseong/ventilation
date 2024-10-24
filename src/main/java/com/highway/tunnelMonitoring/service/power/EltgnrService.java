package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.Eltgnr;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrRunHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrSttus;
import com.highway.tunnelMonitoring.mapper.power.EltgnrMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EltgnrService implements CrudService<Eltgnr> {

    private final EltgnrMapper eltgnrMapper;

    @Override
    public Result<Eltgnr> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<Eltgnr> list = eltgnrMapper.eltgnrFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = eltgnrMapper.eltgnrCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Eltgnr findOne(String eltgnr_no){ return eltgnrMapper.findOne(eltgnr_no); }

    @Override
    @Transactional
    public void enroll(Eltgnr eltgnr){
        eltgnrMapper.eltgnrEnroll(eltgnr);
        eltgnrMapper.eltgnrSttusEnroll(eltgnr.getEltgnr_id(),eltgnr.getLink_id());
    }

    @Override
    @Transactional
    public void update(Eltgnr eltgnr){
        eltgnrMapper.eltgnrUpdate(eltgnr);
    }

    @Override
    @Transactional
    public void delete(Eltgnr eltgnr){
        eltgnrMapper.eltgnrDelete(eltgnr);
    }

    public Result<EltgnrSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<EltgnrSttus> list = eltgnrMapper.eltgnrMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = eltgnrMapper.eltgnrMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<EltgnrAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<EltgnrAlarmHistory> list = eltgnrMapper.eltgnrAlarmHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = eltgnrMapper.eltgnrAlarmCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<EltgnrRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<EltgnrRunHistory> list = eltgnrMapper.eltgnrRunHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = eltgnrMapper.eltgnrRunCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

}
