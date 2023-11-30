package com.java.eshop.s4.mapper;

import com.java.eshop.s4.dto.CreateProductDTO;
import com.java.eshop.s4.dto.ProductDTO;
import com.java.eshop.s4.model.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {
    // source Product -> Al objeto de entrada
    // target ProductDTO -> Al objeto de salida
    ProductDTO toDTO(Product model);

    // source CreateProductDTO -> Al objeto de entrada
    // target Product -> Al objeto de salida
    @Mapping(target = "id", ignore = true)
    Product toModel(CreateProductDTO dto);
}
