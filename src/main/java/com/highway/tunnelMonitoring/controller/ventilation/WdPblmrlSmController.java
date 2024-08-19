package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.ventilation.wdpblmrl.WdPblmrlSm;
import com.highway.tunnelMonitoring.service.ventilation.WdPblmrlSmService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@Transactional(readOnly = true)
@RequestMapping("/ventilation/wdPblmrlSm/*")
public class WdPblmrlSmController extends BaseCrudController<WdPblmrlSm> {

    private final WdPblmrlSmService wdPblmrlSmService;

    public WdPblmrlSmController(WdPblmrlSmService wdPblmrlSmService) {
        super(wdPblmrlSmService);
        this.wdPblmrlSmService = wdPblmrlSmService;
    }


}
