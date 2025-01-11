package com.example.model;

import java.io.Serializable;


public class PolishResponse implements Serializable {

    private String polished_content;
    private Double similarity;

    public String getPolished_content() {
        return polished_content;
    }

    public void setPolished_content(String polished_content) {
        this.polished_content = polished_content;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }

    public PolishResponse(String polished_content, Double similarity) {
        this.polished_content = polished_content;
        this.similarity = similarity;
    }
}
