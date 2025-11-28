package com.example.flashcard.controllers;

import com.example.flashcard.sessions.Sesssion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class SessionController {

    //📌 Best for stateless services.
    @Autowired
    Sesssion sesssion;
    @GetMapping("/session/singleton")
    public void singletonSession(){
        sesssion.singleton();
    }


    //📌 Best for stateful objects, background tasks.
    @GetMapping("/session/prototype")
    public void prototype(){
        sesssion.prototype();
    }

    //Same within request, new for next one
    @GetMapping("/session/request")
    public void request(){
        sesssion.request();
    }

    //One bean per user session
    @GetMapping("/session/session")
    public void session(){
        sesssion.session();
    }

    //One bean per ServletContext (entire application)
    @GetMapping("/session/application")
    public void application(){
        sesssion.application();
    }

    //New bean instance for each WebSocket session
    @GetMapping("/session/websocket")
    public void websocket(){
        sesssion.websocket();
    }
}
