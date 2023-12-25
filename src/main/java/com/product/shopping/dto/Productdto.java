package com.product.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Productdto {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ProductName;

    private long cost;

    private int stock;
}
