package com.productsmanager.services.interfaces;

import com.productsmanager.models.Product;
import com.productsmanager.models.http.UpdateProductRequest;

import java.util.List;

public interface IProductsService{
    List<Product> findProducts();
    Product save (Product product);
    Product update(UpdateProductRequest request, int productId);
}
