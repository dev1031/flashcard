package com.example.flashcard.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonService {
}

//Only one bean instance is created.
