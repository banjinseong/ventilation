package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.power.ups.UpsFaultHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.*;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.mapper.ventilation.JetPanMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JetPanService implements CrudService<JetPan> {

    private final JetPanMapper jetPanMapper;

    @Override
    public Result<JetPan> findAll(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<JetPan> list = jetPanMapper.jetPanFindAll(linkId, offset, size);
        int total = jetPanMapper.jetPanCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public JetPan findOne(String jet_pan_no){ return jetPanMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(JetPan jetPan){
        jetPanMapper.jetPanEnroll(jetPan);
    }

    @Override
    public void update(JetPan jetPan){
        jetPanMapper.jetPanUpdate(jetPan);
    }

    @Override
    public void delete(JetPan jetPan){
        jetPanMapper.jetPanDelete(jetPan);
    }


    public Result<JetPanSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<JetPanSttus> list = jetPanMapper.jetPanMonitor(linkId, offset, size);
        int total = jetPanMapper.jetPanMonitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<JetPanFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<JetPanFaultHistory> list = jetPanMapper.jetPanFaultHistory(linkId, offset, size, startDate, endDate);
        int total = jetPanMapper.jetPanFaultCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<JetPanRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<JetPanRunHistory> list = jetPanMapper.jetPanRunHistory(linkId, offset, size, startDate, endDate);
        int total = jetPanMapper.jetPanRunCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<JetPanStat> stat(String linkId, int page, int size, LocalDate startDate, LocalDate endDate) {
        int offset = (page - 1) * size;
        List<JetPanStat> list = jetPanMapper.jetPanStat(linkId, offset, size, startDate, endDate);
        int total = jetPanMapper.jetPanStatCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }



}
