package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository repository;

    // Setter Injection
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void issueBook() {
        System.out.println("Book Service Started");
        repository.displayBook();
    }
}