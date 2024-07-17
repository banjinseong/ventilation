package com.highway.ventilation.dto;

import lombok.Data;

@Data
public class CommunicationFrameDTO {
    private String senderIp;
    private String destinationIp;
    private String opcode;
    private byte[] data;
}
