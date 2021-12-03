package com.example.bootstrap;

import com.example.service.ProductService;
import com.example.entity.Product;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class DefaultProductsLoader implements CommandLineRunner {

    private final Faker faker;
    private final ProductService service;

    @Override
    public void run(String... args) {
        final List<Product> products = createProductList();
        service.saveAll(products);
    }

    //create the product list
    private List<Product> createProductList() {
        final List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(create());
        }

        return products;
    }

    //create the product
    private Product create() {
        return Product.builder()
                .productName(faker.commerce().productName())
                .material(faker.commerce().material())
                .price(faker.commerce().price())
                .promotionCode(faker.commerce().promotionCode())
                .build();
    }
}
