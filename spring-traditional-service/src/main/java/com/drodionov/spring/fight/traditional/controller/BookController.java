package com.drodionov.spring.fight.traditional.controller;

import com.drodionov.spring.fight.traditional.model.Book;
import com.drodionov.spring.fight.traditional.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/thread-check")
    public String threadCheck() {
        return "Current thread: " + Thread.currentThread() +
                "\nIs virtual: " + Thread.currentThread().isVirtual();
    }
}