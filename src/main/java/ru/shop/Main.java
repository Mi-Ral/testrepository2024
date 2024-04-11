package ru.shop;

import ru.shop.exceptions.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.services.CustomerService;
import ru.shop.services.OrderService;
import ru.shop.services.ProductService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) throws BadOrderCountException {

        ProductRepository productRepository = new ProductRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();

        CustomerService customerService = new CustomerService(customerRepository);
        ProductService productService = new ProductService(productRepository);
        OrderService orderService = new OrderService(orderRepository);

        Customer customer = new Customer(UUID.randomUUID().toString(),"James", "+7999 999 99 99",90);
        Customer customer2 = new Customer(UUID.randomUUID().toString(),"John", "+7999 999 99 88",21);
        Customer customer3 = new Customer(UUID.randomUUID().toString(),"Kirill", "+7999 999 99 77",45);
        customerService.save(customer);
        customerService.save(customer2);
        customerService.save(customer3);


        Product product = new Product(UUID.randomUUID().toString(),"Блок питания", 2000, ProductType.GOOD);
        Product product2 = new Product(UUID.randomUUID().toString(),"Юридическая консультация", 2000, ProductType.SERVICE);
        Product product3 = new Product(UUID.randomUUID().toString(),"Телефон", 2000, ProductType.GOOD);
        productService.save(product);
        productService.save(product2);
        productService.save(product3);


        orderService.add(customer,product,3);
        try {
            orderService.add(customer2, product3,-3);
        } catch (BadOrderCountException e) {
            System.out.println("Bad count value" + e.getMessage());
        }
        orderService.add(customer, product2,4);
        System.out.println("Количество заказчиков: "+customerService.findAll().size());
        System.out.println("Количество заказов всего: " + orderService.findAll().size());
        System.out.println("Количество товаров в разрезе по типам(Service): " + productService
                .findByProductType(ProductType.SERVICE).size());
        System.out.println("Количество товаров в разрезе по типам(GOOD): " + productService
                .findByProductType(ProductType.GOOD).size());
        System.out.println(orderService.getTotalCustomerAmount(customer));


    }

}