package com.firstproject.poo.infraestructure.mapper;

import com.firstproject.poo.domain.dto.Book;
import com.firstproject.poo.domain.dto.Writer;
import com.firstproject.poo.infraestructure.entities.Autor;
import com.firstproject.poo.infraestructure.entities.Libro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WriterMapper {
    @Mappings({
            @Mapping(source = "idAutor", target ="writerID"),
            @Mapping(source = "nombre", target ="name"),
            @Mapping(source = "nacionalidad", target ="nacionality"),
    })
    Writer toWriter(Autor autor);

    @InheritInverseConfiguration
    @Mapping(target = "libros",ignore = true)
    Autor toAutor(Writer writer);
}

