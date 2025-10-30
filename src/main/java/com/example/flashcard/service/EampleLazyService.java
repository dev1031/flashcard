package com.example.flashcard.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class EampleLazyService {
    public EampleLazyService() {
        System.out.println("🔥 HeavyService initialized");
    }

    public void doWork() {
        System.out.println("⚙️ Doing some heavy work...");
    }
}
