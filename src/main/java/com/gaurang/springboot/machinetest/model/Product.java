package com.gaurang.springboot.machinetest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min=2,max = 50)
    @NotNull(message = "Product Name is Required")
    private String name;

    @Size(min=10,max = 1000)
    private String description;

    @ElementCollection
    private List<String> imageUrls;

    @NotNull(message = "Product Price is required")
    private Double price;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private boolean isAvailable = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
