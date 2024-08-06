package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.Lght;
import com.highway.tunnelMonitoring.domain.power.Lmtr;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.mapper.power.LghtMapper;
import com.highway.tunnelMonitoring.mapper.power.LmtrMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LmtrService {

    private final LmtrMapper lmtrMapper;

    public Result<Lmtr> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Lmtr> list = lmtrMapper.findAll(offset, size);
        int total = lmtrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Lmtr findOne(String lmtr_no){ return lmtrMapper.findOne(lmtr_no); }

    public void enroll(Lmtr lmtr){
        lmtrMapper.enroll(lmtr);
    }

    public void update(Lmtr lmtr){
        lmtrMapper.update(lmtr);
    }

    public void delete(String lmtr_no){
        lmtrMapper.delete(lmtr_no);
    }
}
