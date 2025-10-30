package com.example.flashcard.controllers;

import com.example.flashcard.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.HashMap;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/json/api/v1")

public class JSONPlaceholderController {
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    FlashCardService fcs;

    @GetMapping("/todos")
    public String getTodos(){
        String URL = "https://jsonplaceholder.typicode.com/todos";
        ResponseEntity<String> response = restTemplate.getForEntity(URL , String.class);
        fcs.printValues();
        return response.getBody();
    }

    @PostMapping("/posts")
    public String createPost(){
        String URL = "https://jsonplaceholder.typicode.com/posts";
        Map<String , Object> body = new HashMap<>();
        body.put("title", "foo");
        body.put("body", "bar");
        body.put("userId", 1);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, header);

        ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);
        return response.getBody();
    }

    @PutMapping("/put")
    public void updatePost() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Map<String, Object> body = Map.of(
                "id", 1,
                "title", "updated title",
                "body", "updated body",
                "userId", 1
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        restTemplate.put(url, request);
        System.out.println("✅ Updated successfully");
    }

    @PatchMapping("/patch")
    public String patchPost() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Map<String, Object> updates = Map.of("title", "patched title");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(updates, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.PATCH,
                entity,
                String.class
        );

        return response.getBody();
    }

    @DeleteMapping("/delete")
    public String deletePost() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        restTemplate.delete(url);
        return "Record Deleted..";
    }
}
