package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.frplg.Frplg;
import com.highway.tunnelMonitoring.domain.power.frplg.FrplgSttus;
import com.highway.tunnelMonitoring.service.power.FrplgService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * 소화전
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/frplg/*")
public class FrplgController extends BaseCrudController<Frplg> {

    private final FrplgService frplgService;

    public FrplgController(FrplgService frplgService) {
        super(frplgService);
        this.frplgService = frplgService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<FrplgSttus>> monitorFrplg(@RequestParam(defaultValue = "1", name = "page") int page,
                                                           @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<FrplgSttus> result = frplgService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
