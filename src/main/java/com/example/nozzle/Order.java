package com.example.nozzle;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String color;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Material material;
    @Column(unique = true)
    private UUID token = UUID.randomUUID();
    protected Order(){}

    public Order(String name, String email, Material material, String color){
        this.name = name;
        this.email = email;
        this.material = material;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public Material getMaterial() {
        return material;
    }

    public UUID getToken(){
        return token;
    }
}
