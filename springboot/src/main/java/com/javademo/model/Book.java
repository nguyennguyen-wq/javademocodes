package com.javademo.model;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id = UUID.randomUUID();
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;
	@Column(name = "published")
	private boolean published;

	public Book() {
	}

	public Book(String title, String author, boolean published) {
		this.title = title;
		this.author = author;
		this.published = published;
	}

	public UUID getId() {
		return id;
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

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", published=" + published + "]";
	}
}
