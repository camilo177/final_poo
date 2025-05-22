package com.firstproject.poo.infraestructure;

import com.firstproject.poo.domain.dto.Writer;
import com.firstproject.poo.domain.repository.WriterRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AutorRepository implements WriterRepository {

    @Override
    public List<Writer> getAll() {
        return null;
    }

    @Override
    public Optional<Writer> getById(long idWriter) {
        return Optional.empty();
    }

    @Override
    public void deleteByID(long idWriter) {

    }

    @Override
    public Writer save(Writer writer) {
        return null;
    }
}
