package com.example.flashcard.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestService {
    public String getId(){
        return UUID.randomUUID().toString();
    }
}
//One bean per HTTP request