package com.example.controller;

import com.example.dto.ProductDto;
import com.example.dto.ProductResponse;
import com.example.service.ProductService;
import com.example.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;


    //get all products
    //URL - http://localhost:9800/api/products
    @GetMapping("/products")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductResponse> getProducts() {
        return service.getAll();
    }

    //get product by id
    //URL - http://localhost:9800/api/product-by-id?id=1
    @GetMapping("/product-by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponse getProduct(@RequestParam(name = "id") final int id)
            throws EntityNotFoundException {
        final Product p = service.getProduct(id);
        return ProductResponse.from(p);
    }

    //update the product by id
    //URL - http://localhost:9800/api/product-by-id?id=1
    //sample request body -
    /*
    {
        "productName":"Natraj Rubber",
        "material":"Rubber",
        "price":"9.21",
        "promotionCode":"IncrediblePrice1020"
    }
     */
    @PutMapping("/product-by-id")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestParam(name = "id") final int id,
                              @RequestBody final ProductDto dto) throws EntityNotFoundException {
        service.updateProduct(id, dto);
    }
}
