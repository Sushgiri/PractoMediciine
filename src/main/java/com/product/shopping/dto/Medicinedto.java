package com.product.shopping.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medicinedto {
    private String medicineId;
    private String name;

    private String manufacturer;

    private int stock;

    private Double price;

    private boolean prescribed;
}
