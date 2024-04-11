package ru.shop.services;

import ru.shop.exceptions.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.repository.OrderRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderService implements Service<Order>{
    private final OrderRepository repository;
    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    public void add(Customer customer, Product product, long count) throws BadOrderCountException {
        if(count < 0){
            throw new BadOrderCountException("Bad count value");
        }

        Order newOrder = new Order(UUID.randomUUID().toString(),customer.id(), product.id(),
                count, count*product.cost());

        repository.save(newOrder);
    }

    public void save(Order order){
        repository.save(order);
    }

    public List<Order> findAll(){
        return repository.findAll();
    }

    public List<Order> findByCustomer(Customer customer){

        List<Order> list = repository.findAll();
        return list.stream().filter(x -> x.customerId().equals(customer.id())).collect(Collectors.toList());
    }

    public Long getTotalCustomerAmount(Customer customer){
        return findByCustomer(customer).stream().mapToLong(Order::amount).sum();
    }
}
