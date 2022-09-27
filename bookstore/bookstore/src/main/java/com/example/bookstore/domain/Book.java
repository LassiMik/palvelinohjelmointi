package com.example.bookstore.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String title;
	private String author;
	
	@ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
	
	public Book(){}
	
	public Book(String isbn, String title, String author, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCagetory(Category category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		if(this.category != null) 
			return "Bookstore [id"+id+", title="+title+", author="+author+", isbn="+isbn+", category="+this.getCategory()+"]";
		 else 
			return "isbn = "+isbn+",title = "+title+",author = "+author;
		
	}
}