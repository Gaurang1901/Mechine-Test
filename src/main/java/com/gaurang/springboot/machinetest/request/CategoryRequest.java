package com.gaurang.springboot.machinetest.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    @Size(min=2,max = 50)
    @NotNull(message = "Category Name is Required")
    @Column(unique = true)
    private String name;

    @Size(min=10,max = 100)
    private String description;
}
