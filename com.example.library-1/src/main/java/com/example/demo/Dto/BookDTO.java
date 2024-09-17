package com.example.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDTO {
	
	
	@NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotBlank(message = "ISBN is mandatory")
    @Size(min = 10, message = "ISBN must be greater than 10 characters")
    private String isbn;

    private int publicationYear;

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	BookDTO(){
		
	}
	public BookDTO(@NotBlank(message = "Title is mandatory") String title,
			@NotBlank(message = "Author is mandatory") String author,
			@NotBlank(message = "ISBN is mandatory") @Size(min = 10, message = "ISBN must be greater than 10 characters") String isbn,
			int publicationYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
	}

    
}
