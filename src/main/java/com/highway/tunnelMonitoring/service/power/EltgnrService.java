package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.Eltgnr;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.power.eltgnr.EltgnrDTO;
import com.highway.tunnelMonitoring.mapper.power.EltgnrMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EltgnrService {

    private final EltgnrMapper eltgnrMapper;

    public Result<Eltgnr> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Eltgnr> list = eltgnrMapper.findAll(offset, size);
        int total = eltgnrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Eltgnr findOne(String eltgnr_no){ return eltgnrMapper.findOne(eltgnr_no); }

    public void enroll(EltgnrDTO eltgnrDTO){
        eltgnrMapper.enroll(eltgnrDTO);
    }

    public void update(EltgnrDTO eltgnrDTO){
        eltgnrMapper.update(eltgnrDTO);
    }

    public void delete(String eltgnr_no){
        eltgnrMapper.delete(eltgnr_no);
    }
}
