package com.example.flashcard.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "websocket",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebSocketService {
    public String name = "websocket";
}

//Used only in WebSocket-based applications.
