package com.example.nozzle;

import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order findByToken(UUID token){
        return repository.findByToken(token).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
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
