package com.drodionov.spring.fight.reactive.service;

import com.drodionov.spring.fight.reactive.model.Book;
import com.drodionov.spring.fight.reactive.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll()
                .delayElements(java.time.Duration.ofMillis(10)); // Simulate small delay
    }
}