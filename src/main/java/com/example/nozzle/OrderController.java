package com.example.nozzle;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{token}")
    public OrderResponse getOrder(@PathVariable UUID token) {
        return OrderResponse.from(service.findByToken(token));
    }

}
