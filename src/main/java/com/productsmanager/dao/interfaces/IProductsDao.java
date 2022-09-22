package com.productsmanager.dao.interfaces;

import com.productsmanager.models.Product;
import com.productsmanager.models.http.NewProductRequest;
import com.productsmanager.models.http.UpdateProductRequest;

import java.util.List;

public interface IProductsDao {
    List<Product> findProducts();
    Product save(Product product);
    Product update(UpdateProductRequest request, int productId);
}
