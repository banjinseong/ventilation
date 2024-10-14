package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.pump.*;
import com.highway.tunnelMonitoring.service.ventilation.PumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/pump/*")
public class PumpController extends BaseCrudController<Pump> {
    
    private final PumpService pumpService;

    @Autowired
    public PumpController(PumpService pumpService) {
        this.service = pumpService;
        this.pumpService = pumpService;
    }


    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<PumpSttus>> monitorVenAxFn(@RequestParam(defaultValue = "1", name = "page") int page,
                                                            @RequestParam(defaultValue = "10", name = "size") int size,
                                                            @RequestParam(defaultValue = "001", name = "linkId") String linkId,
                                                            @RequestParam(defaultValue = "pump_id", name = "sortColumn") String sortColumn,
                                                            @RequestParam(defaultValue = "asc", name = "sortDirection") String sortDirection) {
        Result<PumpSttus> result = pumpService.monitor(linkId, page, size, sortColumn, sortDirection);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }


    /**
     * 고장이력
     */
    @GetMapping("/faultHistory")
    public ResponseEntity<Result<PumpFaultHistory>> faultHistory(
            @RequestParam(defaultValue = "001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "pump_id", name = "sortColumn") String sortColumn,
            @RequestParam(defaultValue = "asc", name = "sortDirection") String sortDirection) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(pumpService.faultHistory(linkId, page, size, startDate, endDate, sortColumn, sortDirection));
    }


    /**
     * 가동이력
     */
    @GetMapping("/runHistory")
    public ResponseEntity<Result<PumpRunHistory>> runHistory(
            @RequestParam(defaultValue = "001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "pump_id", name = "sortColumn") String sortColumn,
            @RequestParam(defaultValue = "asc", name = "sortDirection") String sortDirection) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(pumpService.runHistory(linkId, page, size, startDate, endDate, sortColumn, sortDirection));
    }


    /**
     * 통계
     */
    @GetMapping("/stat")
    public ResponseEntity<Result<PumpStat>> stat(
            @RequestParam(defaultValue = "001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "pump_id", name = "sortColumn") String sortColumn,
            @RequestParam(defaultValue = "asc", name = "sortDirection") String sortDirection) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDate.now().minusMonths(1);  // 기본적으로 지난 한 달의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDate.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(pumpService.stat(linkId, page, size, startDate, endDate, sortColumn, sortDirection));
    }
}
