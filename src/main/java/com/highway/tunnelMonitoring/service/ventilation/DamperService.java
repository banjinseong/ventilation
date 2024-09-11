package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.vcb.VcbAlarmHistory;
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
    public Result<ExhaustDamper> findAll(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<ExhaustDamper> list = damperMapper.findAll(linkId, offset, size);
        int total = damperMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public ExhaustDamper findOne(String jet_pan_no){ return damperMapper.findOne(jet_pan_no); }

    @Override
    public void enroll(ExhaustDamper exhaustDamper){
        damperMapper.enroll(exhaustDamper);
    }

    @Override
    public void update(ExhaustDamper exhaustDamper){
        damperMapper.update(exhaustDamper);
    }

    @Override
    public void delete(ExhaustDamper exhaustDamper){
        damperMapper.delete(exhaustDamper);
    }


    public Result<ExhaustDamperSttus> monitor(String linkId, int page, int size) {
        int offset = (page - 1) * size;
        List<ExhaustDamperSttus> list = damperMapper.monitor(linkId, offset, size);
        int total = damperMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<ExhaustDamperRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<ExhaustDamperRunHistory> list = damperMapper.runHistory(linkId, offset, size, startDate, endDate);
        int total = damperMapper.runCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

}
