package ru.shop.services;

import java.util.List;

public interface Service<T>{
    void save(T t);

    List<T> findAll();
}
