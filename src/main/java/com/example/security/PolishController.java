package com.example.security;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PolishController {

    @PostMapping("/polish")
    public String processRequest() {
        return "Request processed successfully!";
    }
}
