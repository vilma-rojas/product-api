package com.business.productapi.dto.mapping;

import com.business.productapi.dto.FullProductDto;
import com.business.productapi.dto.ProductDto;
import com.business.productapi.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id",ignore = true)
    FullProductDto productEntityToFullProductDto(ProductEntity productEntity);

    ProductEntity productDtoToProductEntity(ProductDto productDto);

    List<FullProductDto> productsEntitiesToFullProductsDto(List<ProductEntity> productEntity);

}
