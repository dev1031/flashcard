package com.example.flashcard.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class FlashCardService {

    private final int A;
    private final String B;

    @Lazy(false)
    // Spring will inject values from application.properties here
    public FlashCardService(
            @Value("${flashcard.a}") int A,
            @Value("${flashcard.b}") String B) {
        this.A = A;
        this.B = B;
        System.out.println("✅ FlashCardService created with A = " + A + " and B = " + B + " ✅");
    }

    public void printValues() {
        System.out.println("A = " + A + ", B = " + B);
    }
}
