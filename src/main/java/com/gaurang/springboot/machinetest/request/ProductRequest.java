package com.gaurang.springboot.machinetest.request;

import com.gaurang.springboot.machinetest.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @Size(min=2,max = 50)
    @NotNull(message = "Product Name is Required")
    private String name;

    @Size(min=10,max = 1000)
    private String description;

    private List<String> imageUrls;

    @NotNull(message = "Product Price is required")
    private Double price;

    private Integer quantity;

    private Long categoryId;
}
