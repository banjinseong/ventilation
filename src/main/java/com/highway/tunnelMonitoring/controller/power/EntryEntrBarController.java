package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBar;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarFaultHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarRunHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarSttus;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanFaultHistory;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanRunHistory;
import com.highway.tunnelMonitoring.service.power.EntryEntrBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 진입 차단기
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/entryEntrBar/*")
public class EntryEntrBarController extends BaseCrudController<EntryEntrBar> {

    private final EntryEntrBarService entryEntrBarService;

    @Autowired
    public EntryEntrBarController(EntryEntrBarService entryEntrBarService) {
        this.entryEntrBarService = entryEntrBarService;
        this.service = entryEntrBarService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<EntryEntrBarSttus>> monitorEntryEntrBar(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                         @RequestParam(defaultValue = "10", name = "size") int size,
                                                                         @RequestParam(defaultValue = "5공구", name = "linkId") String linkId) {
        Result<EntryEntrBarSttus> result = entryEntrBarService.monitor(linkId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    /**
     * 고장이력
     */
    @GetMapping("/faultHistory")
    public ResponseEntity<Result<EntryEntrBarFaultHistory>> faultHistory(
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
                .body(entryEntrBarService.faultHistory(linkId, page, size, startDate, endDate));
    }



    /**
     * 가동이력
     */
    @GetMapping("/runHistory")
    public ResponseEntity<Result<EntryEntrBarRunHistory>> runHistory(
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
                .body(entryEntrBarService.runHistory(linkId, page, size, startDate, endDate));
    }
}
