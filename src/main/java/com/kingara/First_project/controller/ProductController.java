package com.kingara.First_project.controller;

import com.kingara.First_project.models.ProductRepository;
import com.kingara.First_project.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        try {
            Product _product = productRepository.save(
                    new Product(product.getProductname(), product.getProductdescription(), product.getSupplier(),
                            product.getStock(), true)
            );
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String product_name){
        try {
            List<Product> products = new ArrayList<>();

            if (product_name==null){
                productRepository.findAll().forEach(products::add);
            }
            else{
                productRepository.findByProductname(product_name).forEach(products::add);
            }

            if (products.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Long id){
        try {
           Optional<Product> product =  productRepository.findById(id);

           if (product.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
           }
           return new ResponseEntity<>(product, HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        try {
            Optional<Product> product1 = productRepository.findById(id);
            if (product1.isPresent()){
                Product product2 = product1.get();
                product2.setProductname(product.getProductname());
                product2.setProductdescription(product.getProductdescription());
                product2.setSupplier(product.getSupplier());
                product2.setStock(product.getStock());
                product2.setAvailable(product.isAvailable());

                return new ResponseEntity<>(productRepository.save(product2), HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable("id") Long id){
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.FOUND);
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            productRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/available")
    public ResponseEntity<List<Product>> findByIsAvailable(){
        try{
            List<Product> products = new ArrayList<>();
            productRepository.findByAvailable(true).forEach(products::add);
            if (products.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
