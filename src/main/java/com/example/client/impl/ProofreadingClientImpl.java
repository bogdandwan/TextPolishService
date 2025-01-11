package com.example.client.impl;

import com.example.client.ProofreadingClient;
import com.example.model.PolishRequest;
import com.example.model.proofreding.ProofreadingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProofreadingClientImpl implements ProofreadingClient {

    private final WebClient webClient;
    private List<String> languages;
    private List<String> domains;


    public ProofreadingClientImpl (@Value("${proofread.base.url}") String baseUrl){
        this.webClient = WebClient.builder().defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).baseUrl(baseUrl).build();
        fetchLanguages();
        fetchDomains();
    }

    @Override
    public List<String> languages() {
        return languages;
    }

    @Override
    public List<String> domains() {
        return domains;
    }

    @Override
    public ProofreadingResponse proofread(PolishRequest polishRequest) {
        return webClient
                .post()
                .uri("/proofread")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(polishRequest))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ProofreadingResponse>() {
                })
                .block();
    }

    @Override
    public void fetchLanguages() {
        this.languages = webClient.get()
                .uri("/languages")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {
                })
                .block();
    }

    @Override
    public void fetchDomains() {
        this.domains = webClient.get()
                .uri("/domains")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {
                })
                .doOnError(Throwable::printStackTrace)
                .block();
    }


}
