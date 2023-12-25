package com.product.shopping.entity;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collection = "Product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @Field("product_Name")
   @NotEmpty(message = "Prductname should not be empty")
    private String ProductName;

   @Field("cost")
   @NotNull(message = "Cost should not be empty")
   private long cost;

@Field("stock")
@NotNull(message = "Stock should not be empty")
    private int stock;

 private List<Order> order;

 // we can use set also
 //private Set<Order> order;

//    @OneToMany(mappedBy = "Product",fetch = FetchType.EAGER)
//    private List<Order>  orders = new ArrayList<>();
}
