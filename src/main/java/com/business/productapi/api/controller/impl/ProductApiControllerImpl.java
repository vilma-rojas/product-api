package com.business.productapi.api.controller.impl;

import com.business.productapi.api.controller.ProductApiController;
import com.business.productapi.dto.FullProductDto;
import com.business.productapi.dto.ProductDto;
import com.business.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductApiControllerImpl implements ProductApiController {

    private final ProductService productService;
    
    @Override
    @GetMapping
    public ResponseEntity<List<FullProductDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FullProductDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<FullProductDto> create(@RequestBody ProductDto productDto) {
        FullProductDto fullProductDto = productService.create(productDto);
        return ResponseEntity.created(URI.create("/product/"+fullProductDto.getId())).body(fullProductDto);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody ProductDto productDto) {
        productService.update(id,productDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
