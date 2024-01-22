package com.product.shopping.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.*;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "Product")
@Data
@Document(collection = "Medicine")
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;

    private String medicineId;
       @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Manufacturer is required")
    private String manufacturer;
    @Positive(message = "Stock must be a positive value")
    @NotNull(message = "Stock is required")
    private int stock;
    @Positive(message = "Price must be a positive value")
    @NotNull(message = "Price is required")
    private Double price;

    private boolean prescribed;


    // we can use set also
 //private Set<Order> order;

}
