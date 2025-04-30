package com.drodionov.spring.fight.reactive.controller;

import com.drodionov.spring.fight.reactive.model.Book;
import com.drodionov.spring.fight.reactive.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/slow")
    public Mono<String> getSlowResponse() {
        return Mono.delay(java.time.Duration.ofSeconds(2))
                .thenReturn("Reactive delayed response");
    }
}