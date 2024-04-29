package com.highway.ventilation.service;

import com.highway.ventilation.domain.refgepou.RefgePouVO;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.mapper.RefgePouMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefgePouService {

    private final RefgePouMapper refgePouMapper;

    public List<RefgePouVO> findAll(){
        return refgePouMapper.findAll();
    }

    public RefgePouVO findOne(String pou_no){ return refgePouMapper.findOne(pou_no); }

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
