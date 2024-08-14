package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.domain.power.Trnsfmr;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.trnsfmr.Trnsfmr;
import com.highway.tunnelMonitoring.domain.power.trnsfmr.TrnsfmrSttus;
import com.highway.tunnelMonitoring.service.power.TrnsfmrService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 변압기 (Trnsfmr)
 */
@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
@RequestMapping("/power/trnsfmr/*")
public class TrnsfmrController {

    private final TrnsfmrService trnsfmrService;

    //조회시
    @GetMapping("config/list")
    public ResponseEntity<Result<Trnsfmr>> findAll(@RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Result<Trnsfmr> result = trnsfmrService.findAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //방화문 등록시
    @PostMapping("config/create")
    @Transactional
    public ResponseEntity<String> postTrnsfmr(@RequestBody @Valid Trnsfmr trnsfmr, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            trnsfmrService.enroll(trnsfmr);
            String message = "등록에 성공하셨습니다.";
            return ResponseEntity.ok(message);
        }catch (IllegalAccessError error){
            String errorMessage = "등록에 실패하였습니다: " + error.getMessage(); // 오류 메시지 포맷
            //500으로 메시지 고정, 위에서 유효성검사 하기때문에
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }


    @PutMapping("config/update/")
    @Transactional
    public ResponseEntity<String> putTrnsfmr(@RequestBody @Valid Trnsfmr trnsfmr, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            trnsfmrService.update(trnsfmr);

            String message = "업데이트에 성공하셨습니다.";
            return ResponseEntity.ok(message);
        }catch (IllegalAccessError error){
            String errorMessage = "업데이트에 실패하였습니다: " + error.getMessage(); // 오류 메시지 포맷
            //500으로 메시지 고정, 위에서 유효성검사 하기때문에
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }

    @DeleteMapping("config/delete")
    @Transactional
    public ResponseEntity<String> deleteTrnsfmr(@RequestBody List<String> trnsfmr_nos){
        try {
            for (String trnsfmr_no : trnsfmr_nos) {
                trnsfmrService.delete(trnsfmr_no);
            }
            String message = "삭제에 성공하셨습니다.";
            return ResponseEntity.ok(message);
        }catch (IllegalAccessError error){
            String errorMessage = "삭제에 실패하였습니다: " + error.getMessage(); // 오류 메시지 포맷
            //500으로 메시지 고정, 위에서 유효성검사 하기때문에
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    /**
     * 모니터링
     */
    @GetMapping("monitor")
    public ResponseEntity<Result<TrnsfmrSttus>> monitorTrnsfmr(@RequestParam(defaultValue = "1", name = "page") int page,
                                                               @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<TrnsfmrSttus> result = trnsfmrService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
