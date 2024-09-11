package com.highway.tunnelMonitoring.controller;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.service.CrudService;
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
 * 조명은 기본키가 복합키라 따로 작성.
 *
 */
@RequiredArgsConstructor
public abstract class BaseCrudController<T> {


    protected final CrudService<T> service;

    //조회시
    @GetMapping("config/list")
    public ResponseEntity<Result<T>> findAll(@RequestParam(defaultValue = "1", name = "page") int page,
                                             @RequestParam(defaultValue = "10", name = "size") int size,
                                             @RequestParam(defaultValue = "5공구", name = "linkId") String linkId) {
        Result<T> result = service.findAll(linkId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //등록시
    @PostMapping("config/create")
    @Transactional
    public ResponseEntity<String> postT(@RequestBody @Valid T dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            service.enroll(dto);
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
    public ResponseEntity<String> putT(@RequestBody @Valid T dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        try {
            service.update(dto);
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
    public ResponseEntity<String> deleteT(@RequestBody @Valid List<T> dtos){
        try {
            for (T dto : dtos) {
                service.delete(dto);
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
