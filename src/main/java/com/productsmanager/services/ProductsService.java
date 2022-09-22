package com.productsmanager.services;

import com.productsmanager.dao.interfaces.IProductsDao;
import com.productsmanager.models.Product;
import com.productsmanager.models.http.UpdateProductRequest;
import com.productsmanager.services.interfaces.IProductsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {

    private final IProductsDao productsDao;

    public ProductsService(IProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public List<Product> findProducts() {
        return productsDao.findProducts();
    }

    @Override
    public Product save(Product product) {
        return productsDao.save(product);
    }

    @Override
    public Product update(UpdateProductRequest request, int productId) {
        return productsDao.update(request, productId);
    }
}
