package ru.shop.services;


import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements Service<Product>{
    private ProductRepository productRepository;
    public ProductService(ProductRepository repository){
        this.productRepository = repository;
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findByProductType(ProductType type){
        //return productRepository.findAll().stream().filter(x -> x.productType().equals(type)).collect(Collectors.toList());

        List<Product> list = productRepository.findAll();
        List<Product> newList = new ArrayList<>();

        for (Product product : list) {
            if(product.productType() == (type)){
                newList.add(product);
            }
        }
        return newList;
    }
}
