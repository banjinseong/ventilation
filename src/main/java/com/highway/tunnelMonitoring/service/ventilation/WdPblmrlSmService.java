package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.wdpblmrl.WdPblmrlSm;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WdPblmrlSmService implements CrudService<WdPblmrlSm> {

    private final WdPblmrlSmMapper wdPblmrlSmMapper;

    @Override
    public Result<WdPblmrlSm> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<WdPblmrlSm> list = wdPblmrlSmMapper.findAll(offset, size);
        int total = wdPblmrlSmMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public WdPblmrlSm findOne(String wd_pblml_sm_no){ return wdPblmrlSmMapper.findOne(wd_pblml_sm_no); }

    @Override
    public void enroll(WdPblmrlSm wdPblmrlSm){
        wdPblmrlSmMapper.enroll(wdPblmrlSm);
    }

    @Override
    public void update(WdPblmrlSm wdPblmrlSm){
        wdPblmrlSmMapper.update(wdPblmrlSm);
    }

    @Override
    public void delete(WdPblmrlSm wdPblmrlSm){
        wdPblmrlSmMapper.delete(wdPblmrlSm);
    }
}
