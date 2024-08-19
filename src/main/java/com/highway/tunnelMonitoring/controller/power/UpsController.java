package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.ups.Ups;
import com.highway.tunnelMonitoring.domain.power.ups.UpsSttus;
import com.highway.tunnelMonitoring.service.power.UpsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * UPS (Uninterruptible Power Supply)
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/ups/*")
public class UpsController extends BaseCrudController<Ups> {

    private final UpsService upsService;

    public UpsController(UpsService upsService) {
        super(upsService);
        this.upsService = upsService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<UpsSttus>> monitorUps(@RequestParam(defaultValue = "1", name = "page") int page,
                                                       @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<UpsSttus> result = upsService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
