package com.example.flashcard.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionService {
    public UUID id = UUID.randomUUID();
}
//✔ Same value for same user until logout/session expires.