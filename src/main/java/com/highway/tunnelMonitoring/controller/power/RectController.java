package com.highway.tunnelMonitoring.controller.power;

import com.highway.tunnelMonitoring.domain.power.Rect;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.power.RectDTO;
import com.highway.tunnelMonitoring.service.power.RectService;
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
 * 정류기
 */
@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
@RequestMapping("/power/rect/*")
public class RectController {

    private final RectService rectService;

    //조회시
    @GetMapping("config/list")
    public ResponseEntity<Result<Rect>> findAll(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        Result<Rect> result = rectService.findAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //방화문 등록시
    @PostMapping("config/create")
    @Transactional
    public ResponseEntity<String> postRect(@RequestBody @Valid RectDTO rectDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            rectService.enroll(rectDTO);
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
    public ResponseEntity<String> putRect(@RequestBody @Valid RectDTO rectDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            rectService.update(rectDTO);

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
    public ResponseEntity<String> deleteRect(@RequestBody List<String> rect_nos){
        try {
            for (String rect_no : rect_nos) {
                rectService.delete(rect_no);
            }
            String message = "삭제에 성공하셨습니다.";
            return ResponseEntity.ok(message);
        }catch (IllegalAccessError error){
            String errorMessage = "삭제에 실패하였습니다: " + error.getMessage(); // 오류 메시지 포맷
            //500으로 메시지 고정, 위에서 유효성검사 하기때문에
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
