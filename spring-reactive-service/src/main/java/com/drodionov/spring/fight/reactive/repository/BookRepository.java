package com.drodionov.spring.fight.reactive.repository;

import com.drodionov.spring.fight.reactive.model.Book;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BookRepository extends R2dbcRepository<Book, Long> {
}