package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.damper.ExhaustDamper;
import com.highway.tunnelMonitoring.domain.ventilation.damper.ExhaustDamperRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.damper.ExhaustDamperSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.DamperMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DamperService implements CrudService<ExhaustDamper> {

    private final DamperMapper damperMapper;

    @Override
    public Result<ExhaustDamper> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<ExhaustDamper> list = damperMapper.damperFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = damperMapper.damperCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public ExhaustDamper findOne(String jet_pan_no){ return damperMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(ExhaustDamper exhaustDamper){
        damperMapper.damperEnroll(exhaustDamper);
        damperMapper.damperSttusEnroll(exhaustDamper.getDamper_id(), exhaustDamper.getLink_id());
    }

    @Override
    public void update(ExhaustDamper exhaustDamper){
        damperMapper.damperUpdate(exhaustDamper);
    }

    @Override
    public void delete(ExhaustDamper exhaustDamper){
        damperMapper.damperDelete(exhaustDamper);
    }


    public Result<ExhaustDamperSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<ExhaustDamperSttus> list = damperMapper.damperMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = damperMapper.damperMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<ExhaustDamperRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<ExhaustDamperRunHistory> list = damperMapper.damperRunHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = damperMapper.damperRunCountAll(linkId, startDate, endDate);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

}
