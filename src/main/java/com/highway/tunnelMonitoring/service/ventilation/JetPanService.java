package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.power.ups.UpsFaultHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.*;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.mapper.ventilation.JetPanMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JetPanService implements CrudService<JetPan> {

    private final JetPanMapper jetPanMapper;

    @Override
    public Result<JetPan> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<JetPan> list = jetPanMapper.jetPanFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = jetPanMapper.jetPanCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public JetPan findOne(String jet_pan_no){ return jetPanMapper.findOne(jet_pan_no); }

    @Override
    @Transactional
    public void enroll(JetPan jetPan){
        jetPanMapper.jetPanEnroll(jetPan);
        jetPanMapper.jetPanSttusEnroll(jetPan.getJet_pan_id(), jetPan.getLink_id());
    }

    @Override
    @Transactional
    public void update(JetPan jetPan){
        jetPanMapper.jetPanUpdate(jetPan);
    }

    @Override
    @Transactional
    public void delete(JetPan jetPan){
        jetPanMapper.jetPanDelete(jetPan);
    }


    public Result<JetPanSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<JetPanSttus> list = jetPanMapper.jetPanMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = jetPanMapper.jetPanMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<JetPanFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<JetPanFaultHistory> list = jetPanMapper.jetPanFaultHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = jetPanMapper.jetPanFaultCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<JetPanRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<JetPanRunHistory> list = jetPanMapper.jetPanRunHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = jetPanMapper.jetPanRunCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<JetPanStat> stat(String linkId, int page, int size, LocalDate startDate, LocalDate endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<JetPanStat> list = jetPanMapper.jetPanStat(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = jetPanMapper.jetPanStatCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }


    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void jetPanRecordStat(){
        jetPanMapper.jetPanRecordStat();
    }

    @Transactional
    public void updateSttus(JetPanSttus jetPanSttus){
        jetPanMapper.jetPanUpdateSttus(jetPanSttus);
    }

}
