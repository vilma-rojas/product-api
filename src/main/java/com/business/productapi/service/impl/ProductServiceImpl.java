package com.business.productapi.service.impl;

import com.business.productapi.dto.FullProductDto;
import com.business.productapi.dto.ProductDto;
import com.business.productapi.dto.mapping.ProductMapper;
import com.business.productapi.persistence.entity.ProductEntity;
import com.business.productapi.persistence.repository.ProductRepository;
import com.business.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository ;

    private final ProductMapper productMapper ;

    @Override
    public List<FullProductDto> getAll() {
        List<ProductEntity> productEntities = repository.findAll();
        return productMapper.productsEntitiesToFullProductsDto(productEntities);
    }

    @Override
    public FullProductDto getById(String id) {
    	Optional<ProductEntity> entity = repository.findById(UUID.fromString(id));
    	if(entity.isEmpty()) {
    		return new FullProductDto();
    	}
        return productMapper.productEntityToFullProductDto(entity.get());
    }

    @Override
    public FullProductDto create(ProductDto newProductDto) {

        ProductEntity entity = repository.save(productMapper.productDtoToProductEntity(newProductDto));

        return productMapper.productEntityToFullProductDto(entity);

    }

    @Override
    public void update(String id, ProductDto productDto) {
    	
    	Optional<ProductEntity> entity = repository.findById(UUID.fromString(id));
    	
    	if(!entity.isEmpty()) {
    		
    		repository.save(productMapper.productDtoToProductEntity(productDto));
    		
    	}

    }

    @Override
    public void delete(String id) {
    	
    	repository.deleteById(UUID.fromString(id));

    }

}
