package com.example.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PolishRequest {

    @NotBlank
    private String language;
    @NotBlank
    private String domain;
    @NotBlank
    private String content;

    public void setLanguage(@NotBlank String language) {
        this.language = language;
    }

    public void setDomain(@NotBlank String domain) {
        this.domain = domain;
    }

    public void setContent(@NotBlank String content) {
        this.content = content;
    }

    public @NotBlank String getLanguage() {
        return language;
    }

    public @NotBlank String getDomain() {
        return domain;
    }

    public @NotBlank String getContent() {
        return content;
    }
}
