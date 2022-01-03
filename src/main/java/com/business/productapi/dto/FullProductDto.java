package com.business.productapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FullProductDto extends ProductDto {
    private String id;
}
