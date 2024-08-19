package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxfn;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.venaxfn.VenAxfnSttus;
import com.highway.tunnelMonitoring.service.ventilation.VenAxfnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/venAxfn/*")
public class VenAxfnController extends BaseCrudController<VenAxfn> {

    private final VenAxfnService venAxfnService;

    public VenAxfnController(VenAxfnService venAxfnService) {
        super(venAxfnService);
        this.venAxfnService = venAxfnService;
    }


    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<VenAxfnSttus>> monitorVenAxfn(@RequestParam(defaultValue = "1", name = "page") int page,
                                                               @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<VenAxfnSttus> result = venAxfnService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
