package com.example.flashcard.sessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sesssion {
    @Autowired SingletonService s1;
    @Autowired SingletonService s2;
    public void singleton(){
        System.out.println(s1 == s2);
    }

    @Autowired
    PrototypeService p1;
    PrototypeService p2;
    public void prototype(){
        System.out.println(p1==p2);
    }

    @Autowired
    RequestService r1;
    public void request(){
        System.out.println(r1.getId());
    }

    @Autowired
    SessionService ss1;
    public void session(){
        System.out.println(ss1.toString());
    }

    @Autowired
    ApplicationService ap1;
    public void application(){
        System.out.println(ap1.toString());
    }

    @Autowired
    WebSocketService ws1;
    public void websocket(){
        System.out.println(ws1.name);
    }
}
