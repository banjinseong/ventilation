package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.wdpblmrl.WdPblmrlSm;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.ventilation.WdPblmrlSmGetDTO;
import com.highway.tunnelMonitoring.mapper.ventilation.WdPblmrlSmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WdPblmrlSmService {

    private final WdPblmrlSmMapper wdPblmrlSmMapper;

    public Result<WdPblmrlSm> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<WdPblmrlSm> list = wdPblmrlSmMapper.findAll(offset, size);
        int total = wdPblmrlSmMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public WdPblmrlSm findOne(String wd_pblml_sm_no){ return wdPblmrlSmMapper.findOne(wd_pblml_sm_no); }

    public void enroll(WdPblmrlSmGetDTO wdPblmrlSmGetDTO){
        wdPblmrlSmMapper.enroll(wdPblmrlSmGetDTO);
    }

    public void update(WdPblmrlSmGetDTO wdPblmrlSmGetDTO){
        wdPblmrlSmMapper.update(wdPblmrlSmGetDTO);
    }

    public void delete(String wd_pblml_sm_no){
        wdPblmrlSmMapper.delete(wd_pblml_sm_no);
    }
}
