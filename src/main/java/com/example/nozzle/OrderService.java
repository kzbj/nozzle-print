package com.example.nozzle;

import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(CreateOrderRequest request){
        Order order = new Order(
                request.name(),
                request.email(),
                request.material(),
                request.color(),
                request.quantity(),
                request.address(),
                request.delivery()
        );
        return repository.save(order);
    }
}
