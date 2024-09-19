package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanFaultHistory;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanRunHistory;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanStat;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.*;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.service.ventilation.VenAxFnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/venAxFn/*")
public class VenAxFnController extends BaseCrudController<VenAxFn> {

    private final VenAxFnService venAxfnService;

    @Autowired
    public VenAxFnController(VenAxFnService venAxfnService) {
        this.service = venAxfnService;
        this.venAxfnService = venAxfnService;
    }


    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<VenAxFnSttus>> monitorVenAxFn(@RequestParam(defaultValue = "1", name = "page") int page,
                                                               @RequestParam(defaultValue = "10", name = "size") int size,
                                                               @RequestParam(defaultValue = "LNK001", name = "linkId") String linkId) {
        Result<VenAxFnSttus> result = venAxfnService.monitor(linkId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }


    /**
     * 고장이력
     */
    @GetMapping("/faultHistory")
    public ResponseEntity<Result<VenAxFnFaultHistory>> faultHistory(
            @RequestParam(defaultValue = "LNK001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(venAxfnService.faultHistory(linkId, page, size, startDate, endDate));
    }


    /**
     * 가동이력
     */
    @GetMapping("/runHistory")
    public ResponseEntity<Result<VenAxFnRunHistory>> runHistory(
            @RequestParam(defaultValue = "LNK001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(venAxfnService.runHistory(linkId, page, size, startDate, endDate));
    }


    /**
     * 통계
     */
    @GetMapping("/stat")
    public ResponseEntity<Result<VenAxFnStat>> stat(
            @RequestParam(defaultValue = "LNK001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDate.now().minusMonths(1);  // 기본적으로 지난 한 달의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDate.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(venAxfnService.stat(linkId, page, size, startDate, endDate));
    }
}
