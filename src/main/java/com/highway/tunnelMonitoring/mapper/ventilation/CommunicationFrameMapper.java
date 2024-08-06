package com.highway.tunnelMonitoring.mapper.ventilation;

import com.highway.tunnelMonitoring.dto.ventilation.CommunicationFrameDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunicationFrameMapper {
    void insertCommunicationFrame(CommunicationFrameDTO frame);
}
