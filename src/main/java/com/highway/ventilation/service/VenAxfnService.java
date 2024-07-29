package com.highway.ventilation.service;

import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.domain.venaxfn.VenAxfn;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.dto.Result;
import com.highway.ventilation.dto.VenAxfnGetDTO;
import com.highway.ventilation.mapper.RefgePouMapper;
import com.highway.ventilation.mapper.VenAxfnMapper;
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

    public void enroll(VenAxfnGetDTO venAxfnGetDto){
        venAxfnMapper.enroll(venAxfnGetDto);
    }

    public void update(VenAxfnGetDTO venAxfnGetDto){
        venAxfnMapper.update(venAxfnGetDto);
    }

    public void delete(String ven_axfn_no){
        venAxfnMapper.delete(ven_axfn_no);
    }
}
