package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.powpop.PowPop;
import com.highway.tunnelMonitoring.domain.power.powpop.PowPopSttus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * 수배전반 (PowPop)
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/powPow/*")
public class PowPopController extends BaseCrudController<PowPop> {

    private final PowPopService powPopService;

    public PowPopController(PowPopService powPopService) {
        super(powPopService);
        this.powPopService = powPopService;
    }


    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<PowPopSttus>> monitorPowPop(@RequestParam(defaultValue = "1", name = "page") int page,
                                                             @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<PowPopSttus> result = powPopService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
