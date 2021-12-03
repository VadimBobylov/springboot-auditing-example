package com.example.dto;

import com.example.entity.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode(callSuper = true)
public class ProductResponse extends ProductDto {

    String creationDate;
    String lastModifiedBy;
    String lastModifiedDate;

    private ProductResponse(
            final String productName,
            final String material,
            final String price,
            final String promotionCode,
            final String creationDate,
            final String lastModifiedBy,
            final String lastModifiedDate) {
        super(productName, material, price, promotionCode);
        this.creationDate = creationDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public static ProductResponse from(final Product product) {
        return new ProductResponse(product.getProductName(),
                product.getMaterial(),
                product.getPrice(),
                product.getPromotionCode(),
                product.getCreationDate().toString(),
                product.getLastModifiedBy(),
                product.getLastModifiedDate().toString());
    }
}
