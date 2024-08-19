package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.CO.CmoMsrins;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.CO.CmoSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.CmoMsrinsMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CmoMsrinsService implements CrudService<CmoMsrins> {

    private final CmoMsrinsMapper cmoMsrinsMapper;

    @Override
    public Result<CmoMsrins> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<CmoMsrins> list = cmoMsrinsMapper.findAll(offset, size);
        int total = cmoMsrinsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public CmoMsrins findOne(String cmo_msrins_no){ return cmoMsrinsMapper.findOne(cmo_msrins_no); }

    @Override
    public void enroll(CmoMsrins cmoMsrins){
        cmoMsrinsMapper.enroll(cmoMsrins);
    }

    @Override
    public void update(CmoMsrins cmoMsrins){
        cmoMsrinsMapper.update(cmoMsrins);
    }

    @Override
    public void delete(CmoMsrins cmoMsrins){
        cmoMsrinsMapper.delete(cmoMsrins);
    }

    public Result<CmoSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<CmoSttus> list = cmoMsrinsMapper.monitor(offset, size);
        int total = cmoMsrinsMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
