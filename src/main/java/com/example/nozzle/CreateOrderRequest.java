package com.example.nozzle;

import jakarta.validation.constraints.*;

public record CreateOrderRequest(
        @Size(max = 100)
        String name,

        @NotBlank @Email @Size(max = 254)
        String email,

        @NotNull
        Material material,

        @NotNull
        DetailColor color,

        @Min(1) @Max(100)
        int quantity,

        @NotNull
        DeliveryMethod delivery,

        @NotBlank @Size(max = 200)
        String address
) {}