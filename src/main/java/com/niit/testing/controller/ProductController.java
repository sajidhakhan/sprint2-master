package com.niit.testing.controller;
import com.niit.testing.domain.Product;
import com.niit.testing.domain.ProductDescription;
import com.niit.testing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>((List<Product>) productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductByProductId(@PathVariable String productId) {

        Product product = productService.getProductByProductId(productId);

        if (product != null)
            return new ResponseEntity<Product>(product, HttpStatus.OK);

        return new ResponseEntity<String>("NotFound", HttpStatus.CONFLICT);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
            throws Exception {

        Product saveProduct = productService.saveProduct(product);
        return new ResponseEntity<Product>(saveProduct, HttpStatus.CREATED);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateDomainByDomainId(@PathVariable String productId, @RequestBody Product product)
            throws Exception {
        product.setProductId(productId);
        return ResponseEntity.ok().body(this.productService.updateProductByProductId(product));
    }

    @DeleteMapping("/products/{productId}")
    public HttpStatus deleteProductByProductId(@PathVariable String productId) throws Exception {
        this.productService.deleteProductByProductId(productId);
        return HttpStatus.OK;
    }
}
