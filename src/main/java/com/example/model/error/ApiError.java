package com.example.model.error;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiError implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiError(String message) {
        this.message = message;
    }
}
