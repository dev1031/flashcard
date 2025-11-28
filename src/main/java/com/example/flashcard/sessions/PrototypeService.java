package com.example.flashcard.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeService {
}

//New instance created each time bean is injected / requested
