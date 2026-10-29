package com.example.nozzle;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @NotBlank
    @Email
    @Size(max = 254)
    @Column(nullable = false, length = 254)
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private DetailColor color;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Material material;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID token = UUID.randomUUID();

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, length = 200)
    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private DeliveryMethod delivery;

    @Min(1)
    @Max(100)
    @Column(nullable = false)
    private int quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private OrderStatus status;

    @NotNull
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    protected Order() {}

    public Order(String name, String email, Material material, DetailColor color, int quantity,
                 String address, DeliveryMethod delivery ){
        this.name = name;
        this.email = email;
        this.material = material;
        this.color = color;
        this.address = address;
        this.delivery = delivery;
        this.quantity = quantity;
        this.status = OrderStatus.LOOKING_FOR_PRINTER;
        this.createdAt = Instant.now();
        // TODO add fileKey originalFileName fileSize
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public DetailColor getColor() {
        return color;
    }

    public Material getMaterial() {
        return material;
    }

    public UUID getToken(){
        return token;
    }

    public String getAddress() {
        return address;
    }

    public DeliveryMethod getDelivery() {
        return delivery;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
