package ru.shop.repository;

import ru.shop.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList);
    }
}
