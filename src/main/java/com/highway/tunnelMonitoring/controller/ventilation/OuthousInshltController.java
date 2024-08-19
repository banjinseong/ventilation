package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.inshlt.OuthousInshlt;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.inshlt.OuthousWetherSttus;
import com.highway.tunnelMonitoring.service.ventilation.OuthosInshltService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/inshlt/*")
public class OuthousInshltController extends BaseCrudController<OuthousInshlt> {

    private final OuthosInshltService outhosInshltService;

    public OuthousInshltController(OuthosInshltService outhosInshltService) {
        super(outhosInshltService);
        this.outhosInshltService = outhosInshltService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<OuthousWetherSttus>> monitorOuthousInshlt(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                           @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<OuthousWetherSttus> result = outhosInshltService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
