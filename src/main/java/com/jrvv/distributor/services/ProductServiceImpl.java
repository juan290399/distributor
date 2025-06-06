package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.Product;
import com.jrvv.distributor.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id)
            .map(existing -> {
                existing.setPrdName(product.getPrdName());
                existing.setPrdDescription(product.getPrdDescription());
                existing.setPrdPrice(product.getPrdPrice());
                existing.setPrdStock(product.getPrdStock());
                existing.setPrdCategory(product.getPrdCategory());
                existing.setPrdActive(product.getPrdActive());
                return productRepository.save(existing);
            }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
