package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.venmsrins.VenVsMsrins;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.ventilation.VenVsMsrinsGetDTO;
import com.highway.tunnelMonitoring.mapper.ventilation.VenVsMsrinsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenVsMsrinsService {

    private final VenVsMsrinsMapper venVsMsrinsMapper;

    public Result<VenVsMsrins> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<VenVsMsrins> list = venVsMsrinsMapper.findAll(offset, size);
        int total = venVsMsrinsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public VenVsMsrins findOne(String ven_vs_msrins_no){ return venVsMsrinsMapper.findOne(ven_vs_msrins_no); }

    public void enroll(VenVsMsrinsGetDTO venVsMsrinsGetDTO){
        venVsMsrinsMapper.enroll(venVsMsrinsGetDTO);
    }

    public void update(VenVsMsrinsGetDTO venVsMsrinsGetDTO){
        venVsMsrinsMapper.update(venVsMsrinsGetDTO);
    }

    public void delete(String ven_vs_msrins_no){
        venVsMsrinsMapper.delete(ven_vs_msrins_no);
    }
}
