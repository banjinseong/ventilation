package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.frplg.Frplg;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgSttus;
import com.highway.tunnelMonitoring.service.power.FrplgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 소화전
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/frplg/*")
public class FrplgController extends BaseCrudController<Frplg> {

    private final FrplgService frplgService;

    @Autowired
    public FrplgController(FrplgService frplgService) {
        this.service = frplgService;
        this.frplgService = frplgService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<FrplgSttus>> monitorFrplg(@RequestParam(defaultValue = "1", name = "page") int page,
                                                           @RequestParam(defaultValue = "10", name = "size") int size,
                                                           @RequestParam(defaultValue = "001", name = "linkId") String linkId,
                                                           @RequestParam(defaultValue = "frplg_id", value = "sortColumn") String sortColumn,
                                                           @RequestParam(defaultValue = "asc", value = "sortDirection") String sortDirection) {
        Result<FrplgSttus> result = frplgService.monitor(linkId, page, size, sortColumn, sortDirection);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    /**
     * 경보이력
     */
    @GetMapping("/alarmHistory")
    public ResponseEntity<Result<FrplgAlarmHistory>> alarmHistory(
            @RequestParam(defaultValue = "001", value = "linkId") String linkId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "frplg_id", value = "sortColumn") String sortColumn,
            @RequestParam(defaultValue = "asc", value = "sortDirection") String sortDirection) {

        // 기본값 설정 (startDate 또는 endDate가 null인 경우)
        if (startDate == null) {
            startDate = LocalDateTime.now().minusDays(30);  // 기본적으로 30일간의 데이터 제공
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();  // 기본적으로 오늘까지의 데이터
        }

        return ResponseEntity.status(HttpStatus.OK).body(frplgService.alarmHistory(linkId, page, size, startDate, endDate, sortColumn, sortDirection));
    }
}
