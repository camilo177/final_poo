package com.firstproject.poo.domain.repository;

import com.firstproject.poo.domain.dto.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll();
    List<Book> getByYear(int year);
    Optional<Book> getById(long idBook);
    Book save(Book book);
    void delete(long idBook);
}
