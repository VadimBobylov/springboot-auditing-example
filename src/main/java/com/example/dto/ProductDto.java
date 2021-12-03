package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDto {

    @NonNull
    String productName;
    String material;
    String price;
    String promotionCode;
}
