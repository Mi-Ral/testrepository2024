package ru.shop.services;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;

import java.util.List;

public class CustomerService implements Service<Customer> {
    private CustomerRepository repository;
    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }

    public void save(Customer customer){
        repository.save(customer);
    }

    public List<Customer> findAll(){
        return repository.findAll();
    }
}
