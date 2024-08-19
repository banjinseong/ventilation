package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePou;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePouSttus;
import com.highway.tunnelMonitoring.service.ventilation.RefgePouService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/refge/*")
public class RefgePouController extends BaseCrudController<RefgePou> {

    private final RefgePouService refgePouService;

    public RefgePouController(RefgePouService refgePouService) {
        super(refgePouService);
        this.refgePouService = refgePouService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<RefgePouSttus>> monitorRefgePou(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                 @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<RefgePouSttus> result = refgePouService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
