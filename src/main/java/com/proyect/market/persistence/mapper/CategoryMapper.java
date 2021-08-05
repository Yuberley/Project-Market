package com.proyect.market.persistence.mapper;

import com.proyect.market.domain.Category;
import com.proyect.market.persistence.entity.Categoria;
import org.mapstruct.*;

// Mapper between persistence layer and domain
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
