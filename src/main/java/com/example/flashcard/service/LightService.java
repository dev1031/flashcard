package com.example.flashcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class LightService {

    private final EampleLazyService heavyService;

    @Autowired
    public LightService(@Lazy EampleLazyService heavyService) {
        this.heavyService = heavyService;
        System.out.println("💡 LightService initialized");
    }

    public void performTask() {
        System.out.println("✨ Performing light task...");
        heavyService.doWork();  // only now HeavyService is created
    }
}

