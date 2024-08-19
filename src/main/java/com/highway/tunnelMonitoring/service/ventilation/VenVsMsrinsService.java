package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venmsrins.VenVsMsrins;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.venmsrins.VenVsSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.VenVsMsrinsMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenVsMsrinsService implements CrudService<VenVsMsrins> {

    private final VenVsMsrinsMapper venVsMsrinsMapper;

    @Override
    public Result<VenVsMsrins> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<VenVsMsrins> list = venVsMsrinsMapper.findAll(offset, size);
        int total = venVsMsrinsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public VenVsMsrins findOne(String ven_vs_msrins_no){ return venVsMsrinsMapper.findOne(ven_vs_msrins_no); }

    @Override
    public void enroll(VenVsMsrins venVsMsrins){
        venVsMsrinsMapper.enroll(venVsMsrins);
    }

    @Override
    public void update(VenVsMsrins venVsMsrins){
        venVsMsrinsMapper.update(venVsMsrins);
    }

    @Override
    public void delete(VenVsMsrins venVsMsrins){
        venVsMsrinsMapper.delete(venVsMsrins);
    }

    public Result<VenVsSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<VenVsSttus> list = venVsMsrinsMapper.monitor(offset, size);
        int total = venVsMsrinsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
