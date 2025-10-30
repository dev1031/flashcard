package com.example.flashcard.controllers;

import java.util.*;

import com.example.flashcard.model.Card;
import com.example.flashcard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CardController {
    @Autowired
    CardRepository cardRepository;
    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getAllCards(@RequestParam(required = false) String category) {
        try {
            List<Card> cards = new ArrayList<Card>();
            if (category == null) {
                cardRepository.findAll().forEach(cards::add);
            } else {
                cardRepository.findByCategory(category).forEach(cards::add);
            }

            if (cards.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable("id") long id) {
        try {
            Optional<Card> card = cardRepository.findById(id);
            System.out.println(card);
            if (!card.isPresent()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(card.get(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cards/date")
    public ResponseEntity<List<Card>> getCardsByCreatedAt(@RequestParam(required = false) Date createdAt) {
        try {
            List<Card> cards = new ArrayList<Card>();
            if (createdAt == null) {
                cardRepository.findAll().forEach(cards::add);
            } else {
                cardRepository.findByCreatedAt(createdAt).forEach(cards::add);
            }
            if (cards.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/cards")
//    public ResponseEntity<Card> createCard(@RequestBody Card card){
//        try{
//            Card _card = cardRepository
//                    .save(new Card(card.getTitle(),card.getDescription(),card.getCategory()));
//            return new ResponseEntity<>(_card, HttpStatus.CREATED);
//        }
//        catch(Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/cards")
    public ResponseEntity<List<Card>> createCards(@RequestBody List<Card> cards) {
        try {
            List<Card> cardList = new ArrayList<>();
            for (Card card : cards) {
                cardList.add(new Card(card.getTitle(), card.getDescription(), card.getCategory()));
            }
            List<Card> savedCards = cardRepository.saveAll(cardList);
            return new ResponseEntity<>(savedCards, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
