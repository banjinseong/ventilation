package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.fire.FireAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.fire.FireStat;
import com.highway.tunnelMonitoring.domain.ventilation.fire.FireSttus;
import com.highway.tunnelMonitoring.service.ventilation.FireService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/ventilation/fire/*")
public class FireController {

    private final FireService fireService;

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<FireSttus>> monitorFire(@RequestParam(defaultValue = "1", name = "page") int page,
                                                         @RequestParam(defaultValue = "10", name = "size") int size,
                                                         @RequestParam(defaultValue = "link_id", value = "sortColumn") String sortColumn,
                                                         @RequestParam(defaultValue = "asc", value = "sortDirection") String sortDirection) {
        Result<FireSttus> result = fireService.monitor(page, size, sortColumn, sortDirection);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }


    /**
     * 경보이력
     */
    @GetMapping("/alarmHistory")
    public ResponseEntity<Result<FireAlarmHistory>> alarmHistory(
            @RequestParam(defaultValue = "LNK001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "fire_id", value = "sortColumn") String sortColumn,
            @RequestParam(defaultValue = "asc", value = "sortDirection") String sortDirection) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK).body(fireService.alarmHistory(linkId, page, size, startDate, endDate, sortColumn, sortDirection));
    }



    @GetMapping("/stat")
    public ResponseEntity<Result<FireStat>> stat(
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "fire_id", name = "sortColumn") String sortColumn,
            @RequestParam(defaultValue = "asc", name = "sortDirection") String sortDirection) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDate.now().minusMonths(1);  // 기본적으로 지난 한 달의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDate.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(fireService.stat(page, size, startDate, endDate, sortColumn, sortDirection));
    }
}
