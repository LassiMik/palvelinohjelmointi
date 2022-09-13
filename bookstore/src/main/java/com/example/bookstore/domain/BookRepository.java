package com.example.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Booke, Long> {
	List<Booke> findByAuthor(String author);
}
