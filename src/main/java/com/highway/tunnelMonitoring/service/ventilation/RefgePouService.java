package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePou;
import com.highway.tunnelMonitoring.dto.ventilation.cmomsrins.CmoMsrinsMonitorDTO;
import com.highway.tunnelMonitoring.dto.ventilation.refgepou.RefgePouGetDTO;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.ventilation.refgepou.RefgePouMonitorDTO;
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

    public void enroll(RefgePouGetDTO refgePouGetDTO){
        refgePouMapper.enroll(refgePouGetDTO);
    }

    public void update(RefgePouGetDTO refgePouGetDTO){
        refgePouMapper.update(refgePouGetDTO);
    }

    public void delete(String pou_no){
        refgePouMapper.delete(pou_no);
    }

    public Result<RefgePouMonitorDTO> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<RefgePouMonitorDTO> list = refgePouMapper.monitor(offset, size);
        int total = refgePouMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
