package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.lght.Lght;
import com.highway.tunnelMonitoring.domain.power.lght.LghtSttus;
import com.highway.tunnelMonitoring.mapper.power.LghtMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LghtService implements CrudService<Lght> {

    private final LghtMapper lghtMapper;

    @Override
    public Result<Lght> findAll(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<Lght> list = lghtMapper.lghtFindAll(linkId, offset, size, sortColumn, sortDirection);
        int total = lghtMapper.lghtCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    @Override
    public void enroll(Lght lght){
        lghtMapper.lghtEnroll(lght);
    }

    @Override
    public void update(Lght lght){
        lghtMapper.lghtUpdate(lght);
    }

    @Override
    public void delete(Lght lght){
        lghtMapper.lghtDelete(lght);
    }

    public Result<LghtSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<LghtSttus> list = lghtMapper.lghtMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = lghtMapper.lghtMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }


}
