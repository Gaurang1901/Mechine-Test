package com.gaurang.springboot.machinetest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min=2,max = 50)
    @NotNull(message = "Category Name is Required")
    @Column(unique = true)
    private String name;

    @Size(min=10,max = 100)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
