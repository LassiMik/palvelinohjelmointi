package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Booke;


@Controller

public class BookController { 
		@Autowired
		private BookRepository repository;
	@RequestMapping(value="/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Booke());
		return "addbook";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Booke booke) {
		repository.save(booke);
		return "redirect:booklist";
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id")long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String updateBook(@PathVariable("id")long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		return "/updatebook";
	}
	
}
