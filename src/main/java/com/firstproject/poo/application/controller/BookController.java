package com.firstproject.poo.application.controller;

import com.firstproject.poo.domain.dto.Book;
import com.firstproject.poo.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookSrv;

    @GetMapping()
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(bookSrv.getAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Book> getByID(@PathVariable("id") long bookID){
        return bookSrv.getByID(bookID).map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Book> save (@RequestBody Book book){
        return new ResponseEntity<>(bookSrv.save(book),  HttpStatus.CREATED) ;
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int bookID){
        if(bookSrv.delete(bookID)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
