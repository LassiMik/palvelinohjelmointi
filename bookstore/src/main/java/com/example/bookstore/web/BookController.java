package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Booke;
import com.example.bookstore.domain.CategoryRepository;


@Controller

public class BookController { 
		@Autowired
		private BookRepository repository;
		@Autowired
		private CategoryRepository crepository;
		
		
	@RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Booke());
		model.addAttribute("category", crepository.findAll());
		return "addbook";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save (@ModelAttribute("book") Booke booke) {
		repository.save(booke);
		return "redirect:booklist";
	}
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@ModelAttribute("book") Booke booke) {
		repository.save(booke);
		return "redirect:booklist";
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id")long bookid, Model model) {
		repository.deleteById(bookid);
		return "redirect:../booklist";
	}
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String updateBook(@PathVariable("id")long bookid, Model model) {
		model.addAttribute("book", repository.findById(bookid));
		model.addAttribute("categorys", crepository.findAll());
		return "updatebook";
	}
	
}
