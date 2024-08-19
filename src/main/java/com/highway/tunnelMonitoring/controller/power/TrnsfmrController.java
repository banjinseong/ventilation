package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.trnsfmr.Trnsfmr;
import com.highway.tunnelMonitoring.domain.power.trnsfmr.TrnsfmrSttus;
import com.highway.tunnelMonitoring.service.power.TrnsfmrService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 변압기 (Trnsfmr)
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/trnsfmr/*")
public class TrnsfmrController extends BaseCrudController<Trnsfmr> {

    private final TrnsfmrService trnsfmrService;

    public TrnsfmrController(TrnsfmrService trnsfmrService) {
        super(trnsfmrService);
        this.trnsfmrService = trnsfmrService;
    }


    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<TrnsfmrSttus>> monitorTrnsfmr(@RequestParam(defaultValue = "1", name = "page") int page,
                                                               @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<TrnsfmrSttus> result = trnsfmrService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
