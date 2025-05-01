package com.drodionov.spring.fight.traditional.service;

import com.drodionov.spring.fight.traditional.model.Book;
import com.drodionov.spring.fight.traditional.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Value("${application.response.delay.ms}")
    private int delayMs;

    @SneakyThrows
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        Thread.sleep(delayMs);
        return bookRepository.findAll();
    }
}