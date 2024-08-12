package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.Rect;
import com.highway.tunnelMonitoring.domain.power.Swtbrd;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.power.SwtbrdDTO;
import com.highway.tunnelMonitoring.mapper.power.RectMapper;
import com.highway.tunnelMonitoring.mapper.power.SwtbrdMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SwtbrdService {

    private final SwtbrdMapper swtbrdMapper;

    public Result<Swtbrd> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Swtbrd> list = swtbrdMapper.findAll(offset, size);
        int total = swtbrdMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Swtbrd findOne(String swtbrd_no){ return swtbrdMapper.findOne(swtbrd_no); }

    public void enroll(SwtbrdDTO swtbrdDTO){
        swtbrdMapper.enroll(swtbrdDTO);
    }

    public void update(SwtbrdDTO swtbrdDTO){
        swtbrdMapper.update(swtbrdDTO);
    }

    public void delete(String swtbrd_no){
        swtbrdMapper.delete(swtbrd_no);
    }
}
