package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.PowPop;
import com.highway.tunnelMonitoring.domain.power.Rect;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.power.RectDTO;
import com.highway.tunnelMonitoring.mapper.power.PowPopMapper;
import com.highway.tunnelMonitoring.mapper.power.RectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RectService {

    private final RectMapper rectMapper;

    public Result<Rect> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Rect> list = rectMapper.findAll(offset, size);
        int total = rectMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Rect findOne(String rect_no){ return rectMapper.findOne(rect_no); }

    public void enroll(RectDTO rectDTO){
        rectMapper.enroll(rectDTO);
    }

    public void update(RectDTO rectDTO){
        rectMapper.update(rectDTO);
    }

    public void delete(String rect_no){
        rectMapper.delete(rect_no);
    }
}
