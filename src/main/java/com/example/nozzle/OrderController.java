package com.example.nozzle;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Order createOrder(@RequestBody @Valid Order order){
        return repository.save(order);
    }

}
