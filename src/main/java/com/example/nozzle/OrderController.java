package com.example.nozzle;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    @PostMapping
    public Order createOrder(@RequestBody @Valid CreateOrderRequest request){
        return service.createOrder(request);
    }

}
