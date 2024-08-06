package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.Lmtr;
import com.highway.tunnelMonitoring.domain.power.PowPop;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.mapper.power.LmtrMapper;
import com.highway.tunnelMonitoring.mapper.power.PowPopMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopPopService {

    private final PowPopMapper powPopMapper;

    public Result<PowPop> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<PowPop> list = powPopMapper.findAll(offset, size);
        int total = powPopMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public PowPop findOne(String pow_pop_no){ return powPopMapper.findOne(pow_pop_no); }

    public void enroll(PowPop powPop){
        powPopMapper.enroll(powPop);
    }

    public void update(PowPop powPop){
        powPopMapper.update(powPop);
    }

    public void delete(String pow_pop_no){
        powPopMapper.delete(pow_pop_no);
    }
}
