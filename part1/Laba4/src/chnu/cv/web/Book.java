package chnu.cv.web;

import java.util.Set;

public class Book {
	private Long id;
	private String name;
	private Set<Author> author;
	
	
	public Book() {
	}
	
	public Book(Long id, String name, Set<Author> author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Set<Author> getAuthor() {
		return author;
	}

	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
	
}
