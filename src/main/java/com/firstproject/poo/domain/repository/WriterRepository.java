package com.firstproject.poo.domain.repository;

import com.firstproject.poo.domain.dto.Writer;

import java.util.List;
import java.util.Optional;

public interface WriterRepository {
    List<Writer> getAll();
    Optional<Writer> getById(long idWriter);

    void deleteByID(long idWriter);
    Writer save(Writer writer);
}
