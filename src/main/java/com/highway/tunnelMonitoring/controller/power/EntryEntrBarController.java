package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.controller.BaseCrudController;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBar;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarSttus;
import com.highway.tunnelMonitoring.service.power.EntryEntrBarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * 진입 차단기
 */
@RestController
@Transactional(readOnly = true)
@RequestMapping("/power/entryEntrBar/*")
public class EntryEntrBarController extends BaseCrudController<EntryEntrBar> {

    private final EntryEntrBarService entryEntrBarService;

    public EntryEntrBarController(EntryEntrBarService entryEntrBarService) {
        super(entryEntrBarService);
        this.entryEntrBarService = entryEntrBarService;
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<EntryEntrBarSttus>> monitorEntryEntrBar(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                         @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<EntryEntrBarSttus> result = entryEntrBarService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
