package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.dto.power.EmgncTlphonDTO;
import com.highway.tunnelMonitoring.domain.power.EmgncTlphon;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.mapper.power.EmgncTlphonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmgncTlphonService {

    private final EmgncTlphonMapper emgncTlphonMapper;

    public Result<EmgncTlphon> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<EmgncTlphon> list = emgncTlphonMapper.findAll(offset, size);
        int total = emgncTlphonMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public EmgncTlphon findOne(String emgnc_tlphon_no){ return emgncTlphonMapper.findOne(emgnc_tlphon_no); }

    public void enroll(EmgncTlphonDTO emgncTlphonDTO){
        emgncTlphonMapper.enroll(emgncTlphonDTO);
    }

    public void update(EmgncTlphonDTO emgncTlphonDTO){
        emgncTlphonMapper.update(emgncTlphonDTO);
    }

    public void delete(String emgnc_tlphon_no){
        emgncTlphonMapper.delete(emgnc_tlphon_no);
    }
}
