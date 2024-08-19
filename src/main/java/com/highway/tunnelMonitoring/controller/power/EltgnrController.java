package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.Eltgnr;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrSttus;
import com.highway.tunnelMonitoring.service.power.EltgnrService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 발전기
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/eltgnr/*")
public class EltgnrController extends BaseCrudController<Eltgnr> {

    private final EltgnrService eltgnrService;

    public EltgnrController(EltgnrService eltgnrService) {
        super(eltgnrService);
        this.eltgnrService = eltgnrService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<EltgnrSttus>> monitorEltgnr(@RequestParam(defaultValue = "1", name = "page") int page,
                                                             @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<EltgnrSttus> result = eltgnrService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
