package com.example.client;

import com.example.model.PolishRequest;
import com.example.model.proofreding.ProofreadingResponse;

import java.util.List;

public interface ProofreadingClient{

    List<String> languages();
    List<String> domains();

    ProofreadingResponse proofread(PolishRequest polishRequest);

    void fetchLanguages();

    void fetchDomains();
}
