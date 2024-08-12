package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.Frplg;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.power.FrplgDTO;
import com.highway.tunnelMonitoring.mapper.power.FrplgMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FrplgService {

    private final FrplgMapper frplgMapper;

    public Result<Frplg> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Frplg> list = frplgMapper.findAll(offset, size);
        int total = frplgMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Frplg findOne(String frplg_no){ return frplgMapper.findOne(frplg_no); }

    public void enroll(FrplgDTO frplgDTO){
        frplgMapper.enroll(frplgDTO);
    }

    public void update(FrplgDTO frplgDTO){
        frplgMapper.update(frplgDTO);
    }

    public void delete(String frplg_no){
        frplgMapper.delete(frplg_no);
    }
}
