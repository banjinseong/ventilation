package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.rect.Rect;
import com.highway.tunnelMonitoring.domain.power.rect.RectSttus;
import com.highway.tunnelMonitoring.service.power.RectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * 정류기
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/rect/*")
public class RectController extends BaseCrudController<Rect> {

    private final RectService rectService;

    public RectController(RectService rectService) {
        super(rectService);
        this.rectService = rectService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<RectSttus>> monitorRect(@RequestParam(defaultValue = "1", name = "page") int page,
                                                         @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<RectSttus> result = rectService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
