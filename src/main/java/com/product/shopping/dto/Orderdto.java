package com.product.shopping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orderdto {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int items;

    private  String Buyer;

    private String Review;



}
