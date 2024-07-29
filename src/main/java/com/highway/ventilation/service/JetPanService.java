package com.highway.ventilation.service;

import com.highway.ventilation.domain.jetpan.JetPan;
import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.dto.JetPanGetDTO;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.dto.Result;
import com.highway.ventilation.mapper.JetPanMapper;
import com.highway.ventilation.mapper.RefgePouMapper;
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

    public void enroll(JetPanGetDTO jetPanGetDTO){
        jetPanMapper.enroll(jetPanGetDTO);
    }

    public void update(JetPanGetDTO jetPanGetDTO){
        jetPanMapper.update(jetPanGetDTO);
    }

    public void delete(String jet_pan_no){
        jetPanMapper.delete(jet_pan_no);
    }

}
