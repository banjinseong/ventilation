package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.inshlt.OuthousInshlt;
import com.highway.tunnelMonitoring.dto.ventilation.cmomsrins.CmoMsrinsMonitorDTO;
import com.highway.tunnelMonitoring.dto.ventilation.outhousinshlt.OuthousInshltGetDTO;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.ventilation.outhousinshlt.OuthousInshltMonitorDTO;
import com.highway.tunnelMonitoring.mapper.ventilation.OuthosInshltMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OuthosInshltService {

    private final OuthosInshltMapper outhosInshltMapper;

    public Result<OuthousInshlt> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<OuthousInshlt> list = outhosInshltMapper.findAll(offset, size);
        int total = outhosInshltMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public OuthousInshlt findOne(String inshlt_no){ return outhosInshltMapper.findOne(inshlt_no); }

    public void enroll(OuthousInshltGetDTO outhousInshltGetDTO){
        outhosInshltMapper.enroll(outhousInshltGetDTO);
    }

    public void update(OuthousInshltGetDTO outhousInshltGetDTO){
        outhosInshltMapper.update(outhousInshltGetDTO);
    }

    public void delete(String inshlt_no){
        outhosInshltMapper.delete(inshlt_no);
    }

    public Result<OuthousInshltMonitorDTO> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<OuthousInshltMonitorDTO> list = outhosInshltMapper.monitor(offset, size);
        int total = outhosInshltMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
