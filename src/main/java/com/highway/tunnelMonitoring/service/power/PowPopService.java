package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.powpop.PowPop;
import com.highway.tunnelMonitoring.domain.power.powpop.PowPopSttus;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PowPopService implements CrudService<PowPop> {

    private final PowPopMapper powPopMapper;

    @Override
    public Result<PowPop> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<PowPop> list = powPopMapper.findAll(offset, size);
        int total = powPopMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public PowPop findOne(String pow_pop_no){ return powPopMapper.findOne(pow_pop_no); }

    @Override
    public void enroll(PowPop powPop){
        powPopMapper.enroll(powPop);
    }

    @Override
    public void update(PowPop powPop){
        powPopMapper.update(powPop);
    }

    @Override
    public void delete(PowPop powPop){
        powPopMapper.delete(powPop);
    }

    public Result<PowPopSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<PowPopSttus> list = powPopMapper.monitor(offset, size);
        int total = powPopMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
