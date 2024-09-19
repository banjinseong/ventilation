package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.Eltgnr;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrRunHistory;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrSttus;
import com.highway.tunnelMonitoring.domain.ventilation.heatingcable.HeatingCableAlarmHistory;
import com.highway.tunnelMonitoring.domain.ventilation.pump.PumpRunHistory;
import com.highway.tunnelMonitoring.service.power.EltgnrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 발전기
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/eltgnr/*")
public class EltgnrController extends BaseCrudController<Eltgnr> {

    private final EltgnrService eltgnrService;

    @Autowired
    public EltgnrController(EltgnrService eltgnrService) {
        this.eltgnrService = eltgnrService;
        this.service = eltgnrService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<EltgnrSttus>> monitorEltgnr(@RequestParam(defaultValue = "1", name = "page") int page,
                                                             @RequestParam(defaultValue = "10", name = "size") int size,
                                                             @RequestParam(defaultValue = "LNK001", name = "linkId") String linkId) {
        Result<EltgnrSttus> result = eltgnrService.monitor(linkId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }


    /**
     * 경보이력
     */
    @GetMapping("/alarmHistory")
    public ResponseEntity<Result<EltgnrAlarmHistory>> alarmHistory(
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

        return ResponseEntity.status(HttpStatus.OK).body(eltgnrService.alarmHistory(linkId, page, size, startDate, endDate));
    }


    /**
     * 가동이력
     */
    @GetMapping("/runHistory")
    public ResponseEntity<Result<EltgnrRunHistory>> runHistory(
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
                .body(eltgnrService.runHistory(linkId, page, size, startDate, endDate));
    }
}
