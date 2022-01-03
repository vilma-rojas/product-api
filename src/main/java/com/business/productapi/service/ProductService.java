package com.business.productapi.service;

import com.business.productapi.dto.FullProductDto;
import com.business.productapi.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<FullProductDto> getAll();

    FullProductDto getById(String id);

    FullProductDto create(ProductDto newProductDto);

    void update(String id,ProductDto productDto);

    void delete(String id);

}
