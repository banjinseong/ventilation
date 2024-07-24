package com.highway.ventilation.service;

import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.dto.Result;
import com.highway.ventilation.mapper.RefgePouMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JetPanService {

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
}
