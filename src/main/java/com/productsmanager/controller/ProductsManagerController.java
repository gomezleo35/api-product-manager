package com.productsmanager.controller;

import com.productsmanager.models.Category;
import com.productsmanager.models.Product;
import com.productsmanager.models.http.NewProductRequest;
import com.productsmanager.models.http.UpdateProductRequest;
import com.productsmanager.services.interfaces.IProductsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsManagerController {

    private final IProductsService service;
    private ModelMapper modelMapper;

    public ProductsManagerController(IProductsService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){

        return ResponseEntity.ok(service.findProducts());
    }
    
    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody NewProductRequest request){

        try {
            Product requestProduct = new Product();
            requestProduct.setName(request.getName());
            requestProduct.setDescription(request.getDescription());
            requestProduct.setStatus(request.getStatus());
            requestProduct.setCategory(Category.builder().id(request.getCategoryId()).build());
            Product product = service.save(requestProduct);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }

    }
    @PutMapping("/{productId}/upload")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody UpdateProductRequest request, @PathVariable int productId){
        return ResponseEntity.ok(service.update(request, productId));
    }
}
