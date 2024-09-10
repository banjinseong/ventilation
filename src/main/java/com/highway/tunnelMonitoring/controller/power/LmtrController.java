package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.power.lmtr.Lmtr;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * 조도계 (Lmtr)
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/lmtr/*")
public class LmtrController extends BaseCrudController<Lmtr> {

    private final LmtrService lmtrService;

    public LmtrController(LmtrService lmtrService) {
        super(lmtrService);
        this.lmtrService = lmtrService;
    }

}
