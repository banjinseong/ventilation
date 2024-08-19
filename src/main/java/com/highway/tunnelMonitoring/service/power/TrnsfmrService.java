package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.trnsfmr.Trnsfmr;
import com.highway.tunnelMonitoring.domain.power.trnsfmr.TrnsfmrSttus;
import com.highway.tunnelMonitoring.mapper.power.TrnsfmrMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrnsfmrService implements CrudService<Trnsfmr> {

    private final TrnsfmrMapper trnsfmrMapper;

    @Override
    public Result<Trnsfmr> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Trnsfmr> list = trnsfmrMapper.findAll(offset, size);
        int total = trnsfmrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Trnsfmr findOne(String trnsfmr_no){ return trnsfmrMapper.findOne(trnsfmr_no); }

    @Override
    public void enroll(Trnsfmr trnsfmr){
        trnsfmrMapper.enroll(trnsfmr);
    }

    @Override
    public void update(Trnsfmr trnsfmr){
        trnsfmrMapper.update(trnsfmr);
    }

    @Override
    public void delete(Trnsfmr trnsfmr){
        trnsfmrMapper.delete(trnsfmr);
    }

    public Result<TrnsfmrSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<TrnsfmrSttus> list = trnsfmrMapper.monitor(offset, size);
        int total = trnsfmrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
