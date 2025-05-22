package com.firstproject.poo.domain.service;

import com.firstproject.poo.domain.dto.Book;
import com.firstproject.poo.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public List<Book> getAll(){
        return bookRepo.getAll();
    }
    public Optional<Book> getByID(long bookID){
        return bookRepo.getById(bookID);
    }

    public Book save (Book book){
        return bookRepo.save(book);
    }
    public boolean delete(long bookID){
        if(getByID(bookID).isPresent()){
            bookRepo.delete(bookID);
            return true;
        }
        return false;
    }
}
