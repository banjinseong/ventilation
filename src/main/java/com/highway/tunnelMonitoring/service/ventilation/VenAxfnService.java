package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxfn;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxfnSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.VenAxfnMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenAxfnService {

    private final VenAxfnMapper venAxfnMapper;

    public Result<VenAxfn> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<VenAxfn> list = venAxfnMapper.findAll(offset, size);
        int total = venAxfnMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public VenAxfn findOne(String ven_axfn_no){ return venAxfnMapper.findOne(ven_axfn_no); }

    public void enroll(VenAxfn venAxfn){
        venAxfnMapper.enroll(venAxfn);
    }

    public void update(VenAxfn venAxfn){
        venAxfnMapper.update(venAxfn);
    }

    public void delete(String ven_axfn_no){
        venAxfnMapper.delete(ven_axfn_no);
    }


    public Result<VenAxfnSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<VenAxfnSttus> list = venAxfnMapper.monitor(offset, size);
        int total = venAxfnMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
