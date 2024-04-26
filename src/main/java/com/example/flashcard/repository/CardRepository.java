package com.example.flashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flashcard.model.Card;
import java.util.*;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByCategory(String category);
    List<Card> findByCreatedAt(Date createdAt);
    //List<Card> findByCreatedAtDateGreaterThan(Date createdAt);
}
