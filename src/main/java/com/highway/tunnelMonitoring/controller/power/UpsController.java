package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarFaultHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarRunHistory;
import com.highway.tunnelMonitoring.domain.power.ups.Ups;
import com.highway.tunnelMonitoring.domain.power.ups.UpsFaultHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsRunHistory;
import com.highway.tunnelMonitoring.domain.power.ups.UpsSttus;
import com.highway.tunnelMonitoring.service.power.UpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * UPS (Uninterruptible Power Supply)
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/ups/*")
public class UpsController extends BaseCrudController<Ups> {

    private final UpsService upsService;

    @Autowired
    public UpsController(UpsService upsService) {
        this.service = upsService;
        this.upsService = upsService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<UpsSttus>> monitorUps(@RequestParam(defaultValue = "1", name = "page") int page,
                                                       @RequestParam(defaultValue = "10", name = "size") int size,
                                                       @RequestParam(defaultValue = "LNK001", name = "linkId") String linkId) {
        Result<UpsSttus> result = upsService.monitor(linkId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    /**
     * 고장이력
     */
    @GetMapping("/faultHistory")
    public ResponseEntity<Result<UpsFaultHistory>> faultHistory(
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
                .body(upsService.faultHistory(linkId, page, size, startDate, endDate));
    }



    /**
     * 가동이력
     */
    @GetMapping("/runHistory")
    public ResponseEntity<Result<UpsRunHistory>> runHistory(
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
                .body(upsService.runHistory(linkId, page, size, startDate, endDate));
    }
}
