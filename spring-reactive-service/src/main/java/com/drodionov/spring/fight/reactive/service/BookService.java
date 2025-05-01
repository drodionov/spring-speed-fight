package com.drodionov.spring.fight.reactive.service;

import com.drodionov.spring.fight.reactive.model.Book;
import com.drodionov.spring.fight.reactive.repository.BookRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static java.time.Duration.ofMillis;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Value("${application.response.delay.ms}")
    private int delayMs;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll().delayElements(ofMillis(delayMs));
    }
}