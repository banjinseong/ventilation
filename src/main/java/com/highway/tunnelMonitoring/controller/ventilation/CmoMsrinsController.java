package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.CO.CmoMsrins;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.CO.CmoSttus;
import com.highway.tunnelMonitoring.service.ventilation.CmoMsrinsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/cmoMsrins")
public class CmoMsrinsController extends BaseCrudController<CmoMsrins> {

    private final CmoMsrinsService cmoMsrinsService;

    public CmoMsrinsController(CmoMsrinsService cmoMsrinsService) {
        super(cmoMsrinsService); // 부모 클래스의 생성자를 호출하여 service 필드 주입
        this.cmoMsrinsService = cmoMsrinsService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<CmoSttus>> monitorCmoMsrins(@RequestParam(defaultValue = "1", name = "page") int page,
                                                             @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<CmoSttus> result = cmoMsrinsService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

}
