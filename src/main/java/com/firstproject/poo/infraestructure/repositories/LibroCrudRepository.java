package com.firstproject.poo.infraestructure.repositories;

import com.firstproject.poo.infraestructure.entities.Libro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibroCrudRepository extends CrudRepository<Libro,Long> {
    List<Libro> findByAnioPublicacion(int anioPublicacion);

}
