package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.ups.Ups;
import com.highway.tunnelMonitoring.domain.power.ups.UpsSttus;
import com.highway.tunnelMonitoring.service.power.UpsService;
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
 * UPS (Uninterruptible Power Supply)
 */
@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
@RequestMapping("/power/ups/*")
public class UpsController {

    private final UpsService upsService;

    //조회시
    @GetMapping("config/list")
    public ResponseEntity<Result<Ups>> findAll(@RequestParam(defaultValue = "1") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        Result<Ups> result = upsService.findAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //방화문 등록시
    @PostMapping("config/create")
    @Transactional
    public ResponseEntity<String> postUps(@RequestBody @Valid Ups ups, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            upsService.enroll(ups);
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
    public ResponseEntity<String> putUps(@RequestBody @Valid Ups ups, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            upsService.update(ups);

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
    public ResponseEntity<String> deleteUps(@RequestBody List<String> ups_nos){
        try {
            for (String ups_no : ups_nos) {
                upsService.delete(ups_no);
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
    public ResponseEntity<Result<UpsSttus>> monitorUps(@RequestParam(defaultValue = "1", name = "page") int page,
                                                       @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<UpsSttus> result = upsService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
