package com.niit.testing.service;

import com.niit.testing.domain.Product;
import com.niit.testing.domain.ProductDescription;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    void deleteProductByProductId(String productId) throws Exception;
    Product updateProductByProductId(Product product) throws Exception;
    List<Product> getAllProducts();
    Product getProductByProductId(String productId);
}
