package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.lmtr.Lmtr;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LmtrService implements CrudService<Lmtr> {

    private final LmtrMapper lmtrMapper;

    @Override
    public Result<Lmtr> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Lmtr> list = lmtrMapper.findAll(offset, size);
        int total = lmtrMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public Lmtr findOne(String lmtr_no){ return lmtrMapper.findOne(lmtr_no); }

    @Override
    public void enroll(Lmtr lmtr){
        lmtrMapper.enroll(lmtr);
    }

    @Override
    public void update(Lmtr lmtr){
        lmtrMapper.update(lmtr);
    }

    @Override
    public void delete(Lmtr lmtr){
        lmtrMapper.delete(lmtr);
    }
}
