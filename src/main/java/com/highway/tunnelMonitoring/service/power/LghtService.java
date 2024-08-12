package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.Lght;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.power.lght.LghtDTO;
import com.highway.tunnelMonitoring.mapper.power.LghtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LghtService {

    private final LghtMapper lghtMapper;

    public Result<Lght> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Lght> list = lghtMapper.findAll(offset, size);
        int total = lghtMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Lght findOne(String lght_group_no, String lght_knd){ return lghtMapper.findOne(lght_group_no, lght_knd); }

    public void enroll(LghtDTO lghtDTO){
        lghtMapper.enroll(lghtDTO);
    }

    public void update(LghtDTO lghtDTO){
        lghtMapper.update(lghtDTO);
    }

    public void delete(String lght_group_no, String lght_knd){
        lghtMapper.delete(lght_group_no, lght_knd);
    }
}
