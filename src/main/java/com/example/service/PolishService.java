package com.example.service;

import com.example.model.PolishRequest;
import com.example.model.PolishResponse;

public interface PolishService {
    PolishResponse processRequest(PolishRequest polishRequest);

}
