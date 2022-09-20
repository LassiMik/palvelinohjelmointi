package com.example.bookstore.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Booke> books;
	
	public Category(){}
	
	public Category (String name) {
		super();
		this.name = name;
	}
	
	public Long id() {
		return id;
	}
	
	public void id(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Booke> getBooks() {
		return books;
	}

	public void setBook(List<Booke> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Category [categoryid="+id+". name="+name+"]";
	}
	
}