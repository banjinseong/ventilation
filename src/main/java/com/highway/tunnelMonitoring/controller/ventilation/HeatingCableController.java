package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCable;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableSttus;
import com.highway.tunnelMonitoring.service.ventilation.HeatingCableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/cable/*")
public class HeatingCableController extends BaseCrudController<HeatingCable> {

    private final HeatingCableService heatingCableService;

    @Autowired
    public HeatingCableController(HeatingCableService heatingCableService) {
        this.service = heatingCableService;
        this.heatingCableService = heatingCableService;
    }


    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<HeatingCableSttus>> monitorJetPan(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                   @RequestParam(defaultValue = "10", name = "size") int size,
                                                                   @RequestParam(defaultValue = "001", name = "linkId") String linkId,
                                                                   @RequestParam(defaultValue = "cable_id", value = "sortColumn") String sortColumn,
                                                                   @RequestParam(defaultValue = "asc", value = "sortDirection") String sortDirection) {
        Result<HeatingCableSttus> result = heatingCableService.monitor(linkId, page, size, sortColumn, sortDirection);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }


    /**
     * 가동이력
     */
    @GetMapping("/runHistory")
    public ResponseEntity<Result<HeatingCableRunHistory>> runHistory(
            @RequestParam(defaultValue = "001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "cable_id", value = "sortColumn") String sortColumn,
            @RequestParam(defaultValue = "asc", value = "sortDirection") String sortDirection) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(heatingCableService.runHistory(linkId, page, size, startDate, endDate, sortColumn, sortDirection));
    }


    /**
     * 경보이력
     */
    @GetMapping("/alarmHistory")
    public ResponseEntity<Result<HeatingCableAlarmHistory>> alarmHistory(
            @RequestParam(defaultValue = "001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "cable_id", value = "sortColumn") String sortColumn,
            @RequestParam(defaultValue = "asc", value = "sortDirection") String sortDirection) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK).body(heatingCableService.alarmHistory(linkId, page, size, startDate, endDate, sortColumn, sortDirection));
    }
 }
