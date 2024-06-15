package com.umg.examen.services.impl;



import com.umg.examen.entities.Product;
import com.umg.examen.repositories.ProductRepository;
import com.umg.examen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    };
    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public void create(Product product) {
        productRepository.save(product);
    }
    public void update(Long id, Product product){
        if (productRepository.existsById(id)){
            product.setId(id);
            productRepository.save(product);
        }

    };
    public void delete(Long id){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
    };
}