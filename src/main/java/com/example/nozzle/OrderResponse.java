package com.example.nozzle;

public record OrderResponse(
        OrderStatus status,
        Material material,
        DetailColor color,
        DeliveryMethod delivery,
        int quantity,
        String address
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getStatus(),
                order.getMaterial(),
                order.getColor(),
                order.getDelivery(),
                order.getQuantity(),
                order.getAddress()
        );
    }
}