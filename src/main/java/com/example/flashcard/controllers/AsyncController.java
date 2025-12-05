package com.example.flashcard.controllers;

import com.example.flashcard.async.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin(origins = "*")

public class AsyncController {
    @Autowired
    AsyncService asyncService;
    @GetMapping("/async")
    public CompletableFuture<String> getAsync() {
        return asyncService.doWork();
    }
}
