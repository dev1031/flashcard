package com.example.flashcard.async;

import com.example.flashcard.FlashcardApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    private static final Logger LOG = LoggerFactory.getLogger(FlashcardApplication.class);

    @Async
    public CompletableFuture<String> doWork() {
        try {
            LOG.warn("Thread is going for sleep--"+ Thread.currentThread());
            Thread.sleep(2000); // simulate slow job
        } catch (Exception ignored) {}

        LOG.info("🎇🎇🎇🎇Completing the request 📢📢📢📢📢📢");
        return CompletableFuture.completedFuture("Async Response");
    }
}
