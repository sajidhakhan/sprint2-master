package com.niit.testing.service;

import com.niit.testing.domain.Product;
import com.niit.testing.domain.ProductDescription;
import com.niit.testing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public void deleteProductByProductId(String productId) throws Exception {
        Optional<Product> productDbTesting=this.productRepository.findById(productId);
        if(productDbTesting.isPresent()){
            this.productRepository.delete(productDbTesting.get());
        }
        else{
            throw new Exception("Product not found");
        }

    }

    @Override
    public Product updateProductByProductId(Product product) throws Exception {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByProductId(String productId) {
        Product product = productRepository.findById(productId).get();
        return product;
    }
}
