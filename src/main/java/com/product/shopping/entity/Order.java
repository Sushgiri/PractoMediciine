package com.product.shopping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

import javax.validation.constraints.Size;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int items;

    @NotEmpty(message = "Buyername must not be empty")
    private  String Buyer;


    @Size(min = 5,message = "review must contain atleat 5 words")
    private String Review;


    private Product product;

//    @ManyToOne
//    @JoinColumn(name = "Product_id")
//    private Product product;

}
