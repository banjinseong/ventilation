package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.lght.Lght;
import com.highway.tunnelMonitoring.domain.power.lght.LghtSttus;
import com.highway.tunnelMonitoring.service.power.LghtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/lght/*")
public class LghtController extends BaseCrudController<Lght> {

    private final LghtService lghtService;

    @Autowired
    public LghtController(LghtService lghtService) {
        this.lghtService = lghtService;
        this.service = lghtService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<LghtSttus>> monitorLght(@RequestParam(defaultValue = "1", name = "page") int page,
                                                             @RequestParam(defaultValue = "10", name = "size") int size,
                                                             @RequestParam(defaultValue = "LNK001", name = "linkId") String linkId,
                                                             @RequestParam(defaultValue = "lght_id", value = "sortColumn") String sortColumn,
                                                             @RequestParam(defaultValue = "asc", value = "sortDirection") String sortDirection) {
        Result<LghtSttus> result = lghtService.monitor(linkId, page, size, sortColumn, sortDirection);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }


}
