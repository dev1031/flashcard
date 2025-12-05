package com.example.flashcard;

import com.example.flashcard.headers.Address;
import com.example.flashcard.headers.Customer;
import com.example.flashcard.headers.CustomerRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlashcardApplication {
	private static final Logger log = LoggerFactory.getLogger(FlashcardApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FlashcardApplication.class, args);
	}

	@Autowired
	CustomerRepository customers;

	@PostConstruct
	public void init() { // this method name can be anything
		customers.save(new Customer("Dave", "Matthews",  "MALE",
				new Address("4711 Some Place", "54321", "Charlottesville", "VA")));
	}
}
