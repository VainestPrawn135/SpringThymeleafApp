package com.example.demo.models.entity;

import java.util.ArrayList;
import java.util.List;

public class BooksCreationDto {
    private List<Books> books;

    public BooksCreationDto(List<Books> books) {
    	this.books = books;
	}

	public BooksCreationDto() {
		this.books = new ArrayList<>();
	}

	public void addBook(Books books){
        this.books.add(books);
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}