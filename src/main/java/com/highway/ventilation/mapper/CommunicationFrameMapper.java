package com.highway.ventilation.mapper;

import com.highway.ventilation.dto.CommunicationFrameDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunicationFrameMapper {
    void insertCommunicationFrame(CommunicationFrameDTO frame);
}
