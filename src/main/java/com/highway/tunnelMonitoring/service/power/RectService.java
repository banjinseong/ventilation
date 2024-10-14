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
    public Result<Rect> findAll(String linkId, int page, int size, String sort_column, String sort_direction) {
        int offset = (page - 1) * size;
        List<Rect> list = rectMapper.rectFindAll(linkId, offset, size);
        int total = rectMapper.rectCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Rect findOne(String rect_no){ return rectMapper.findOne(rect_no); }

    @Override
    public void enroll(Rect rect){
        rectMapper.rectEnroll(rect);
    }

    @Override
    public void update(Rect rect){
        rectMapper.rectUpdate(rect);
    }

    @Override
    public void delete(Rect rect){
        rectMapper.rectDelete(rect);
    }

    public Result<RectSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<RectSttus> list = rectMapper.rectMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = rectMapper.rectMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<RectAlarmHistory> alarmHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<RectAlarmHistory> list = rectMapper.rectAlarmHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = rectMapper.rectAlarmCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
