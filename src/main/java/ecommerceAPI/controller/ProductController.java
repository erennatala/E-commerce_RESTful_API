package ecommerceAPI.controller;

import ecommerceAPI.model.Product;
import ecommerceAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getALLProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //@GetMapping id
    @GetMapping("/id")
    public ResponseEntity<Product> getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    //@PostMapping
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
       Product createdProduct = productRepository.save(product);
         return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Product productToUpdate = productRepository.findById(id).orElse(null);
        if (productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            Product updatedProduct = productRepository.save(productToUpdate);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id) {
        Product productToDelete = productRepository.findById(id).orElse(null);
        if (productToDelete != null) {
            productRepository.delete(productToDelete);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
