package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePou;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.refgepou.RefgePouSttus;
import com.highway.tunnelMonitoring.service.ventilation.RefgePouService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
@RequestMapping("/ventilation/refge/*")
public class RefgePouController {

    private final RefgePouService refgePouService;

    //조회시
    @GetMapping("config/list")
    public ResponseEntity<Result<RefgePou>> findAll(@RequestParam(defaultValue = "1", name = "page") int page,
                                                    @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<RefgePou> result = refgePouService.findAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //방화문 등록시
    @PostMapping("config/create")
    @Transactional
    public ResponseEntity<String> postRefge(@RequestBody @Valid RefgePou refgePou, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            refgePouService.enroll(refgePou);
            String message = "등록에 성공하셨습니다.";
            return ResponseEntity.ok(message);
        }catch (IllegalAccessError error){
            String errorMessage = "등록에 실패하였습니다: " + error.getMessage(); // 오류 메시지 포맷
            //500으로 메시지 고정, 위에서 유효성검사 하기때문에
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }


    @PutMapping("config/update")
    @Transactional
    public ResponseEntity<String> putRefge(@RequestBody @Valid RefgePou refgePou, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            refgePouService.update(refgePou);
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
    public ResponseEntity<String> deleteRefge(@RequestBody List<String> pouNos){
        try {
            for (String pouNo : pouNos) {
                refgePouService.delete(pouNo);
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
    public ResponseEntity<Result<RefgePouSttus>> monitorRefgePou(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                 @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<RefgePouSttus> result = refgePouService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
