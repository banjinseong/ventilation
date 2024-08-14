package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPan;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanSttus;
import com.highway.tunnelMonitoring.mapper.ventilation.JetPanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JetPanService {

    private final JetPanMapper jetPanMapper;

    public Result<JetPan> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<JetPan> list = jetPanMapper.findAll(offset, size);
        int total = jetPanMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public JetPan findOne(String jet_pan_no){ return jetPanMapper.findOne(jet_pan_no); }

    public void enroll(JetPan jetPan){
        jetPanMapper.enroll(jetPan);
    }

    public void update(JetPan jetPan){
        jetPanMapper.update(jetPan);
    }

    public void delete(String jet_pan_no){
        jetPanMapper.delete(jet_pan_no);
    }


    public Result<JetPanSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<JetPanSttus> list = jetPanMapper.monitor(offset, size);
        int total = jetPanMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
