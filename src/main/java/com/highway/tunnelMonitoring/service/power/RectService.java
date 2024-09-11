package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.rect.Rect;
import com.highway.tunnelMonitoring.domain.power.rect.RectAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.rect.RectSttus;
import com.highway.tunnelMonitoring.mapper.power.RectMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RectService implements CrudService<Rect> {

    private final RectMapper rectMapper;

    @Override
    public Result<Rect> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Rect> list = rectMapper.findAll(offset, size);
        int total = rectMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Rect findOne(String rect_no){ return rectMapper.findOne(rect_no); }

    @Override
    public void enroll(Rect rect){
        rectMapper.enroll(rect);
    }

    @Override
    public void update(Rect rect){
        rectMapper.update(rect);
    }

    @Override
    public void delete(Rect rect){
        rectMapper.delete(rect);
    }

    public Result<RectSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<RectSttus> list = rectMapper.monitor(offset, size);
        int total = rectMapper.monitorCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<RectAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate) {
        int offset = (page - 1) * size;
        List<RectAlarmHistory> list = rectMapper.alarmHistory(linkId, offset, size, startDate, endDate);
        int total = rectMapper.alarmCountAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
