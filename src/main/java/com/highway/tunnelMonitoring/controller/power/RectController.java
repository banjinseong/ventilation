package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.rect.Rect;
import com.highway.tunnelMonitoring.domain.power.rect.RectAlarmHistory;
import com.highway.tunnelMonitoring.domain.power.rect.RectSttus;
import com.highway.tunnelMonitoring.service.power.RectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 정류기
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/rect/*")
public class RectController extends BaseCrudController<Rect> {

    private final RectService rectService;

    @Autowired
    public RectController(RectService rectService) {
        this.service = rectService;
        this.rectService = rectService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<RectSttus>> monitorRect(@RequestParam(defaultValue = "1", name = "page") int page,
                                                         @RequestParam(defaultValue = "10", name = "size") int size,
                                                         @RequestParam(defaultValue = "LNK001", name = "linkId") String linkId) {
        Result<RectSttus> result = rectService.monitor(linkId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    /**
     * 경보이력
     */
    @GetMapping("/alarmHistory")
    public ResponseEntity<Result<RectAlarmHistory>> alarmHistory(
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

        return ResponseEntity.status(HttpStatus.OK).body(rectService.alarmHistory(linkId, page, size, startDate, endDate));
    }
}
