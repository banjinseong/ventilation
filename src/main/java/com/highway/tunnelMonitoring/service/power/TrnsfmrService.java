package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.Swtbrd;
import com.highway.tunnelMonitoring.domain.power.Trnsfmr;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.mapper.power.SwtbrdMapper;
import com.highway.tunnelMonitoring.mapper.power.TrnsfmrMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrnsfmrService {

    private final TrnsfmrMapper trnsfmrMapper;

    public Result<Trnsfmr> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Trnsfmr> list = trnsfmrMapper.findAll(offset, size);
        int total = trnsfmrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Trnsfmr findOne(String trnsfmr_no){ return trnsfmrMapper.findOne(trnsfmr_no); }

    public void enroll(Trnsfmr trnsfmr){
        trnsfmrMapper.enroll(trnsfmr);
    }

//    public void update(Trnsfmr trnsfmr){
//        trnsfmrMapper.update(trnsfmr);
//    }

    public void delete(String trnsfmr_no){
        trnsfmrMapper.delete(trnsfmr_no);
    }
}
