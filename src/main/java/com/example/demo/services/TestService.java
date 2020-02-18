package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class TestService {

    @Async
    public CompletableFuture<String> process() throws InterruptedException {
        log.info("process");
        long i = 0;
        do {
            i++;
            log.info("while " + i);
            Thread.sleep(1000);
        } while (i!=5);
        return CompletableFuture.completedFuture(Thread.currentThread().getName() + " done.");

    }
}
