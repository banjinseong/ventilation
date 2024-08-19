package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.venmsrins.VenVsMsrins;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.venmsrins.VenVsSttus;
import com.highway.tunnelMonitoring.service.ventilation.VenVsMsrinsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/venVsMsrins/*")
public class VenVsMsrinsController extends BaseCrudController<VenVsMsrins> {

    private final VenVsMsrinsService venVsMsrinsService;

    public VenVsMsrinsController(VenVsMsrinsService venVsMsrinsService) {
        super(venVsMsrinsService);
        this.venVsMsrinsService = venVsMsrinsService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<VenVsSttus>> monitorVenVsMsrins(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                 @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<VenVsSttus> result = venVsMsrinsService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
