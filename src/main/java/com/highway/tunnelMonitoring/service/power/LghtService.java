package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.lght.Lght;
import com.highway.tunnelMonitoring.domain.power.lght.LghtSttus;
import com.highway.tunnelMonitoring.mapper.power.LghtMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LghtService implements CrudService<Lght> {

    private final LghtMapper lghtMapper;

    @Override
    public Result<Lght> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Lght> list = lghtMapper.findAll(offset, size);
        int total = lghtMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public Lght findOne(String lght_group_no, String lght_knd){ return lghtMapper.findOne(lght_group_no, lght_knd); }

    @Override
    public void enroll(Lght lght){
        lghtMapper.enroll(lght);
    }

    @Override
    public void update(Lght lght){
        lghtMapper.update(lght);
    }

    @Override
    public void delete(Lght lght){
        lghtMapper.delete(lght);
    }

    public Result<LghtSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<LghtSttus> list = lghtMapper.monitor(offset, size);
        int total = lghtMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
