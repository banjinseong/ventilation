package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPan;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.jetpan.JetPanSttus;
import com.highway.tunnelMonitoring.service.ventilation.JetPanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/jetPan/*")
public class JetPanController extends BaseCrudController<JetPan> {

    private final JetPanService jetPanService;

    public JetPanController(JetPanService jetPanService) {
        super(jetPanService);
        this.jetPanService = jetPanService;

    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<JetPanSttus>> monitorJetPan(@RequestParam(defaultValue = "1", name = "page") int page,
                                                             @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<JetPanSttus> result = jetPanService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
