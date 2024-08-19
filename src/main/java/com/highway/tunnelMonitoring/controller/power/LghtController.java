package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.lght.Lght;
import com.highway.tunnelMonitoring.domain.power.lght.LghtSttus;
import com.highway.tunnelMonitoring.service.power.LghtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * 조명 (Lght)
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/lght/*")
public class LghtController extends BaseCrudController<Lght> {

    private final LghtService lghtService;

    public LghtController(LghtService lghtService) {
        super(lghtService);
        this.lghtService = lghtService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<LghtSttus>> monitorLght(@RequestParam(defaultValue = "1", name = "page") int page,
                                                         @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<LghtSttus> result = lghtService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
