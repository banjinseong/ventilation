package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.emgnctlphon.EmgncTlphon;
import com.highway.tunnelMonitoring.domain.power.emgnctlphon.EmgncTlphonSttus;
import com.highway.tunnelMonitoring.service.power.EmgncTlphonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



/**
 * 비상전화
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/emgncTlphon/*")
public class EmgncTlphonController extends BaseCrudController<EmgncTlphon> {

    private final EmgncTlphonService emgncTlphonService;

    public EmgncTlphonController(EmgncTlphonService emgncTlphonService) {
        super(emgncTlphonService);
        this.emgncTlphonService = emgncTlphonService;
    }


    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<EmgncTlphonSttus>> monitorEmgncTlphon(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                       @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<EmgncTlphonSttus> result = emgncTlphonService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
