package com.highway.ventilation.controller;

import com.highway.ventilation.domain.RefgePouVO;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.dto.Result;
import com.highway.ventilation.service.RefgePouService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RefgePouController {

    private final RefgePouService refgePouService;

    @GetMapping("/refge")
    public Result<RefgePouGetDTO> findAll(){
        List<RefgePouGetDTO> list = refgePouService.findAll().stream()
                .map(RefgePouGetDTO::new)
                .collect(Collectors.toList());
        return new Result(list);
    }
}
