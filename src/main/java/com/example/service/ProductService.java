package com.example.service;

import com.example.dto.ProductDto;
import com.example.dto.ProductResponse;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    //save all products in the db
    public void saveAll(final List<Product> products) {
        repository.saveAll(products);
    }

    //get all products from the db
    public List<ProductResponse> getAll() {
        log.info("Getting all products");
        return repository.findAll()
                .stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

    //get product by id from the db
    public Product getProduct(final int id) throws EntityNotFoundException {
        log.info("Getting product id = {}", id);
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Product %s not found", id)));
    }

    //update product in the db
    public void updateProduct(final int id, final ProductDto dto) throws EntityNotFoundException {
        log.info("Updating product id = {}", id);
        getProduct(id);
        final Product p = Product.builder()
                .id(id)
                .productName(dto.getProductName())
                .material(dto.getMaterial())
                .price(dto.getPrice())
                .promotionCode(dto.getPromotionCode())
                .build();
        repository.save(p);
    }
}
