package com.highway.tunnelMonitoring.controller.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.inshlt.OuthousInshlt;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.ventilation.cmomsrins.CmoMsrinsMonitorDTO;
import com.highway.tunnelMonitoring.dto.ventilation.outhousinshlt.OuthousInshltGetDTO;
import com.highway.tunnelMonitoring.dto.ventilation.outhousinshlt.OuthousInshltMonitorDTO;
import com.highway.tunnelMonitoring.service.ventilation.OuthosInshltService;
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
@RequestMapping("/ventilation/inshlt/*")
public class OuthousInshltController {

    private final OuthosInshltService outhosInshltService;

    //조회시
    @GetMapping("config/list")
    public ResponseEntity<Result<OuthousInshlt>> findAll(@RequestParam(defaultValue = "1") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Result<OuthousInshlt> result = outhosInshltService.findAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //방화문 등록시
    @PostMapping("config/create")
    @Transactional
    public ResponseEntity<String> postOuthousInshlt(@RequestBody @Valid OuthousInshltGetDTO outhousInshltGetDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            outhosInshltService.enroll(outhousInshltGetDTO);
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
    public ResponseEntity<String> putOuthousInshlt( @RequestBody @Valid OuthousInshltGetDTO outhousInshltGetDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            outhosInshltService.update(outhousInshltGetDTO);
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
    public ResponseEntity<String> deleteOuthousInshlt(@RequestBody List<String> inshlt_nos){
        try {
            for (String inshlt_no : inshlt_nos) {
                outhosInshltService.delete(inshlt_no);
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
    public ResponseEntity<Result<OuthousInshltMonitorDTO>> monitorOuthousInshlt(@RequestParam(defaultValue = "1", name = "page") int page,
                                                                                @RequestParam(defaultValue = "10", name = "size") int size) {
        Result<OuthousInshltMonitorDTO> result = outhosInshltService.monitor(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
