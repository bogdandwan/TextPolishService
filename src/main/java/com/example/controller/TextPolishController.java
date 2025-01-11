package com.example.controller;

import com.example.model.PolishRequest;
import com.example.model.PolishResponse;
import com.example.service.PolishService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextPolishController {

    private final PolishService polishService;

    public TextPolishController(PolishService polishService) {
        this.polishService = polishService;
    }


    @PostMapping("/polish")
    public PolishResponse processRequest(@RequestBody @Validated PolishRequest polishRequest){
        return polishService.processRequest(polishRequest);
    }


}
