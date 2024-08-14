package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePou;
import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePouSttus;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.mapper.ventilation.RefgePouMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefgePouService {

    private final RefgePouMapper refgePouMapper;

    public Result<RefgePou> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<RefgePou> list = refgePouMapper.findAll(offset, size);
        int total = refgePouMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public RefgePou findOne(String pou_no){ return refgePouMapper.findOne(pou_no); }

    public void enroll(RefgePou refgePou){
        refgePouMapper.enroll(refgePou);
    }

    public void update(RefgePou refgePou){
        refgePouMapper.update(refgePou);
    }

    public void delete(String pou_no){
        refgePouMapper.delete(pou_no);
    }

    public Result<RefgePouSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<RefgePouSttus> list = refgePouMapper.monitor(offset, size);
        int total = refgePouMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
