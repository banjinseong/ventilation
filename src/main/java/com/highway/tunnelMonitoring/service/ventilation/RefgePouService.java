package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePou;
import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePouSttus;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefgePouService implements CrudService<RefgePou> {

    private final RefgePouMapper refgePouMapper;

    @Override
    public Result<RefgePou> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<RefgePou> list = refgePouMapper.findAll(offset, size);
        int total = refgePouMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public RefgePou findOne(String pou_no){ return refgePouMapper.findOne(pou_no); }

    @Override
    public void enroll(RefgePou refgePou){
        refgePouMapper.enroll(refgePou);
    }

    @Override
    public void update(RefgePou refgePou){
        refgePouMapper.update(refgePou);
    }

    @Override
    public void delete(RefgePou refgePou){
        refgePouMapper.delete(refgePou);
    }

    public Result<RefgePouSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<RefgePouSttus> list = refgePouMapper.monitor(offset, size);
        int total = refgePouMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
