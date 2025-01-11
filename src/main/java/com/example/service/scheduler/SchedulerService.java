package com.example.service.scheduler;

import com.example.client.ProofreadingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private ProofreadingClient proofreadingClient;

    @Scheduled(cron = "0 0 12 * * ?")
    public void updateLanguages(){
        proofreadingClient.fetchLanguages();
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void updateDomains(){
        proofreadingClient.fetchDomains();
    }

}
