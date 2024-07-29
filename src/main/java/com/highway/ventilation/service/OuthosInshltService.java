package com.highway.ventilation.service;

import com.highway.ventilation.domain.inshlt.OuthousInshlt;
import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.dto.OuthousInshltGetDTO;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.dto.Result;
import com.highway.ventilation.mapper.OuthosInshltMapper;
import com.highway.ventilation.mapper.RefgePouMapper;
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
}
