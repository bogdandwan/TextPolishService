package com.example.service.impl;

import com.example.client.ProofreadingClient;
import com.example.model.PolishRequest;
import com.example.model.PolishResponse;
import com.example.model.exception.ValidationException;
import com.example.model.proofreding.ProofreadingResponse;
import com.example.service.PolishService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.springframework.stereotype.Service;

@Service
public class PolishServiceImpl implements PolishService {


    private final ProofreadingClient proofreadingClient;

    public PolishServiceImpl(ProofreadingClient proofreadingClient) {
        this.proofreadingClient = proofreadingClient;
    }

    @Override
    public PolishResponse processRequest(PolishRequest polishRequest) {
        validateLanguage(polishRequest.getLanguage());
        validateDomain(polishRequest.getDomain());
        validateContent(polishRequest.getContent());

        final ProofreadingResponse response = proofreadingClient.proofread(polishRequest);

        String cleanRequestContent = removeTags(polishRequest.getContent());
        String cleanProofreadContent = removeTags(response.getProofread_content());
        final Double similarity = calculateSimilarity(cleanRequestContent, cleanProofreadContent);

        return new PolishResponse(response.getProofread_content(), similarity);
    }

    private String removeTags(String input) {
        if (input == null) {
            return "";
        }
        return input.replaceAll("<[^>]*>", "").trim();
    }


    private Double calculateSimilarity(String content, String proofreadContent) {

        JaroWinklerSimilarity similarity = new JaroWinklerSimilarity();
        Double rawSimilarity = similarity.apply(content, proofreadContent);
        return Math.round(rawSimilarity * 100.0) / 100.0;
    }

    private void validateContent(String content) {
        String[] words = content.trim().split("\\s+");
        if (words.length > 30) {
            throw new ValidationException("The input string contains more than 30 words.");
        }
    }


    private void validateDomain(String domain) {
        if (!proofreadingClient.domains().contains(domain)){
            throw new ValidationException("Incorrect domain!");
        }
    }

    private void validateLanguage(String language) {

        if (!proofreadingClient.languages().contains(language)){
            throw new ValidationException("Incorrect language!");
        }

    }


}
