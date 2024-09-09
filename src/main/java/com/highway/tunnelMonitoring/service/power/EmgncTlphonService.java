package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.emgnctlphon.EmgncTlphon;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.emgnctlphon.EmgncTlphonSttus;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmgncTlphonService implements CrudService<EmgncTlphon> {

    private final EmgncTlphonMapper emgncTlphonMapper;

    @Override
    public Result<EmgncTlphon> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<EmgncTlphon> list = emgncTlphonMapper.findAll(offset, size);
        int total = emgncTlphonMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public EmgncTlphon findOne(String emgnc_tlphon_no){ return emgncTlphonMapper.findOne(emgnc_tlphon_no); }

    @Override
    public void enroll(EmgncTlphon emgncTlphon){
        emgncTlphonMapper.enroll(emgncTlphon);
    }

    @Override
    public void update(EmgncTlphon emgncTlphon){
        emgncTlphonMapper.update(emgncTlphon);
    }

    @Override
    public void delete(EmgncTlphon emgncTlphon){
        emgncTlphonMapper.delete(emgncTlphon);
    }

    public Result<EmgncTlphonSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<EmgncTlphonSttus> list = emgncTlphonMapper.monitor(offset, size);
        int total = emgncTlphonMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
