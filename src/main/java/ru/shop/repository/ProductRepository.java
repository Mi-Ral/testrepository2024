package ru.shop.repository;

import ru.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<Product> {
    private ArrayList<Product> productList = new ArrayList<>();
    @Override
    public void save(Product product){
        productList.add(product);
    }

    public List<Product> findAll(){
        return new ArrayList<>(productList);
    }
}
