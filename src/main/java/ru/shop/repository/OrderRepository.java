package ru.shop.repository;

import ru.shop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements Repository<Order>{
    private ArrayList<Order> orderList = new ArrayList<>();
    @Override
    public void save(Order order) {
        orderList.add(order);
    }
    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orderList);
    }
}
