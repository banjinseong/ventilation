package com.highway.tunnelMonitoring.dto.ventilation;

import lombok.Data;

@Data
public class CommunicationFrameDTO {
    private String senderIp;
    private String destinationIp;
    private String opcode;
    private byte[] data;
}
