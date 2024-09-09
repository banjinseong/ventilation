package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.swtbrd.Swtbrd;
import com.highway.tunnelMonitoring.domain.power.swtbrd.SwtbrdSttus;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SwtbrdService implements CrudService<Swtbrd> {

    private final SwtbrdMapper swtbrdMapper;

    @Override
    public Result<Swtbrd> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Swtbrd> list = swtbrdMapper.findAll(offset, size);
        int total = swtbrdMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
//
//    @Override
//    public Swtbrd findOne(String swtbrd_no){ return swtbrdMapper.findOne(swtbrd_no); }

    @Override
    public void enroll(Swtbrd swtbrd){
        swtbrdMapper.enroll(swtbrd);
    }

    @Override
    public void update(Swtbrd swtbrd){
        swtbrdMapper.update(swtbrd);
    }

    @Override
    public void delete(Swtbrd swtbrd){
        swtbrdMapper.delete(swtbrd);
    }

    public Result<SwtbrdSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<SwtbrdSttus> list = swtbrdMapper.monitor(offset, size);
        int total = swtbrdMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}

