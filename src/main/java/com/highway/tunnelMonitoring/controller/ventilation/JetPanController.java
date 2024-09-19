package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.*;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.service.ventilation.JetPanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/jetPan/*")
public class JetPanController extends BaseCrudController<JetPan> {

    private final JetPanService jetPanService;

    @Autowired
    public JetPanController(JetPanService jetPanService) {
        this.service = jetPanService;
        this.jetPanService = jetPanService;

    }


    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<JetPanSttus>> monitorJetPan(@RequestParam(defaultValue = "1", name = "page") int page,
                                                             @RequestParam(defaultValue = "10", name = "size") int size,
                                                             @RequestParam(defaultValue = "LNK001", name = "linkId") String linkId) {
        Result<JetPanSttus> result = jetPanService.monitor(linkId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }


    @GetMapping("/faultHistory")
    public ResponseEntity<Result<JetPanFaultHistory>> faultHistory(
            @RequestParam(value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(jetPanService.faultHistory(linkId, page, size, startDate, endDate));
    }



    @GetMapping("/runHistory")
    public ResponseEntity<Result<JetPanRunHistory>> runHistory(
            @RequestParam(value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(jetPanService.runHistory(linkId, page, size, startDate, endDate));
    }

    @GetMapping("/stat")
    public ResponseEntity<Result<JetPanStat>> stat(
            @RequestParam(value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDate.now().minusMonths(1);  // 기본적으로 지난 한 달의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDate.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(jetPanService.stat(linkId, page, size, startDate, endDate));
    }


}
