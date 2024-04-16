package com.highway.ventilation.mapper;

import com.highway.ventilation.domain.RefgePouVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefgePouMapper {
    List<RefgePouVO> findAll();
}
