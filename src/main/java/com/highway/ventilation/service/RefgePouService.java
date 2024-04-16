package com.highway.ventilation.service;

import com.highway.ventilation.domain.RefgePouVO;
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
}
