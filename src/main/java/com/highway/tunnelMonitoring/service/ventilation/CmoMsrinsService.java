package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.CO.CmoMsrins;
import com.highway.tunnelMonitoring.dto.ventilation.cmomsrins.CmoMsrinsGetDTO;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.ventilation.cmomsrins.CmoMsrinsMonitorDTO;
import com.highway.tunnelMonitoring.mapper.ventilation.CmoMsrinsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CmoMsrinsService {

    private final CmoMsrinsMapper cmoMsrinsMapper;

    public Result<CmoMsrins> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<CmoMsrins> list = cmoMsrinsMapper.findAll(offset, size);
        int total = cmoMsrinsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public CmoMsrins findOne(String cmo_msrins_no){ return cmoMsrinsMapper.findOne(cmo_msrins_no); }

    public void enroll(CmoMsrinsGetDTO cmoMsrinsGetDTO){
        cmoMsrinsMapper.enroll(cmoMsrinsGetDTO);
    }

    public void update(CmoMsrinsGetDTO cmoMsrinsGetDTO){
        cmoMsrinsMapper.update(cmoMsrinsGetDTO);
    }

    public void delete(String cmo_msrins_no){
        cmoMsrinsMapper.delete(cmo_msrins_no);
    }

    public Result<CmoMsrinsMonitorDTO> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<CmoMsrinsMonitorDTO> list = cmoMsrinsMapper.monitor(offset, size);
        int total = cmoMsrinsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
