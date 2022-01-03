package com.business.productapi.api.controller;

import com.business.productapi.dto.FullProductDto;
import com.business.productapi.dto.ProductDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SwaggerDefinition(tags = {@Tag(name = "Product", description = "Product Description")})
@Api(tags = {"Product"},value = "Product")
public interface ProductApiController {

    ResponseEntity<List<FullProductDto>> getAll();

    ResponseEntity<FullProductDto> getById(String id);

    ResponseEntity<FullProductDto> create(ProductDto productDto);

    ResponseEntity<Void> update(String id,ProductDto productDto);

    ResponseEntity<Void> delete(String id);

}
