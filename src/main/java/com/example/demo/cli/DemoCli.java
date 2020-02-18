package com.example.demo.cli;

import com.example.demo.services.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Slf4j
@Component
public class DemoCli implements CommandLineRunner {

    private final TestService service;

    @Override
    public void run(String... args) throws Exception {
        log.info("Start command line runner");
        CompletableFuture<String> future = service.process();
        CompletableFuture<String> future2 = service.process();
        CompletableFuture<String> future3 = service.process();

        //wait for all async methods to do work
        CompletableFuture.allOf(future, future2, future3).join();
        System.out.println(future.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}
