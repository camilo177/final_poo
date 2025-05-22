package com.firstproject.poo.infraestructure;

import com.firstproject.poo.domain.dto.Book;
import com.firstproject.poo.domain.repository.BookRepository;
import com.firstproject.poo.infraestructure.entities.Libro;
import com.firstproject.poo.infraestructure.mapper.BookMapper;
import com.firstproject.poo.infraestructure.repositories.LibroCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibroRepository  implements BookRepository {
    @Autowired
    public LibroCrudRepository libroRepo;
    @Autowired
    public BookMapper mapper;
    @Override
    public List<Book> getAll() {
        List<Libro> libros  = (List<Libro>) libroRepo.findAll();
       return mapper.toBooks(libros);
    }

    @Override
    public List<Book> getByYear(int year) {
        List<Libro> libros = (List<Libro>) libroRepo.findByAnioPublicacion(year);
        return mapper.toBooks(libros);
    }

    @Override
    public Optional<Book> getById(long idBook) {
        Optional<Libro> libro = libroRepo.findById(idBook);
        return mapper.toBooksOptional(libro);
    }

    @Override
    public Book save(Book book) {
       Libro libro = mapper.toLibro(book);
       return mapper.toBook(libroRepo.save(libro));
    }

    @Override
    public void delete(long idBook) {
        libroRepo.deleteById(idBook);
    }
}
