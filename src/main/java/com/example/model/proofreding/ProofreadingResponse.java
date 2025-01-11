package com.example.model.proofreding;

import lombok.Data;

@Data
public class ProofreadingResponse {

    private String proofread_content;

    public String getProofread_content() {
        return proofread_content;
    }

    public void setProofread_content(String proofread_content) {
        this.proofread_content = proofread_content;
    }
}
