package com.productsmanager.dao;

import com.productsmanager.dao.interfaces.IProductsDao;
import com.productsmanager.models.Category;
import com.productsmanager.models.Product;
import com.productsmanager.models.http.NewProductRequest;
import com.productsmanager.models.http.UpdateProductRequest;
import com.productsmanager.repository.ProductsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductsDao implements IProductsDao {

    private final ProductsRepository repository;

    public ProductsDao(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findProducts() {
        return repository.findAll();
    }

    @Override
    public Product save(Product request) {
        return repository.save(request);
    }

    @Override
    public Product update(UpdateProductRequest request, int productId) {
        Optional<Product> products = this.repository.findById(productId);
        Product product = products.get();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setStatus(request.getStatus());
        product.setCategory(Category.builder().id(request.getCategoryId()).name(request.getName()).build());
        return repository.save(product);
    }
}
