package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxfn;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxfnSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.VenAxfnMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenAxfnService implements CrudService<VenAxfn> {

    private final VenAxfnMapper venAxfnMapper;

    @Override
    public Result<VenAxfn> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<VenAxfn> list = venAxfnMapper.findAll(offset, size);
        int total = venAxfnMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public VenAxfn findOne(String ven_axfn_no){ return venAxfnMapper.findOne(ven_axfn_no); }

    @Override
    public void enroll(VenAxfn venAxfn){
        venAxfnMapper.enroll(venAxfn);
    }

    @Override
    public void update(VenAxfn venAxfn){
        venAxfnMapper.update(venAxfn);
    }

    @Override
    public void delete(VenAxfn venAxfn){
        venAxfnMapper.delete(venAxfn);
    }


    public Result<VenAxfnSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<VenAxfnSttus> list = venAxfnMapper.monitor(offset, size);
        int total = venAxfnMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
