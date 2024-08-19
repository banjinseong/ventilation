package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.swtbrd.Swtbrd;
import com.highway.tunnelMonitoring.domain.power.swtbrd.SwtbrdSttus;
import com.highway.tunnelMonitoring.service.power.SwtbrdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 배전반 (Swtbrd)
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/swtbrd/*")
public class SwtbrdController extends BaseCrudController<Swtbrd> {

    private final SwtbrdService swtbrdService;

    public SwtbrdController(SwtbrdService swtbrdService) {
        super(swtbrdService);
        this.swtbrdService = swtbrdService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<SwtbrdSttus>> monitorSwtbrd(@RequestParam(defaultValue = "1", name = "page") int page,
                                                             @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<SwtbrdSttus> result = swtbrdService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
