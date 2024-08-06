package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.service.ModbusRTUService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModbusController {
    private final ModbusRTUService modbusRTUService;

    public ModbusController(ModbusRTUService modbusRTUService) {
        this.modbusRTUService = modbusRTUService;
    }

    // 레지스터 읽기 요청 핸들러
    @GetMapping("/readRegisters")
    public int[] readRegisters(@RequestParam int unitId, @RequestParam int ref, @RequestParam int count) {
        return modbusRTUService.readRegisters(unitId, ref, count);
    }

    // 레지스터 쓰기 요청 핸들러
    @GetMapping("/writeRegisters")
    public String writeRegisters(@RequestParam int unitId, @RequestParam int ref, @RequestParam int[] values) {
        modbusRTUService.writeRegisters(unitId, ref, values);
        return "Registers written successfully";
    }
}