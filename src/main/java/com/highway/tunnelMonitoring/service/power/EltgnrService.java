package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.Eltgnr;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrSttus;
import com.highway.tunnelMonitoring.mapper.power.EltgnrMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EltgnrService implements CrudService<Eltgnr, String> {

    private final EltgnrMapper eltgnrMapper;

    @Override
    public Result<Eltgnr> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Eltgnr> list = eltgnrMapper.findAll(offset, size);
        int total = eltgnrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    @Override
    public Eltgnr findOne(String eltgnr_no){ return eltgnrMapper.findOne(eltgnr_no); }

    @Override
    public void enroll(Eltgnr eltgnr){
        eltgnrMapper.enroll(eltgnr);
    }

    @Override
    public void update(Eltgnr eltgnr){
        eltgnrMapper.update(eltgnr);
    }

    @Override
    public void delete(String eltgnr_no){
        eltgnrMapper.delete(eltgnr_no);
    }

    public Result<EltgnrSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<EltgnrSttus> list = eltgnrMapper.monitor(offset, size);
        int total = eltgnrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
