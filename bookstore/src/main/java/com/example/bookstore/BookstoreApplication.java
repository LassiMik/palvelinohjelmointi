package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Booke;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner BookeDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Save a couple of categories");
			crepository.save(new Category("Adventure"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Fantasy"));
			
			log.info("Save a couple of books");
			repository.save(new Booke("1232323-21", "A farewell to Arms", "Ernest Hemingway", crepository.findByName("Adventure").get(0)));
			repository.save(new Booke("2212343-5", "Animal Farm", "George Orwell", crepository.findByName("Romance").get(0)));
			log.info("fetch all students");
			for (Booke booke:repository.findAll()) {
				log.info(booke.toString());
			}
		
		};
	}
	
}
