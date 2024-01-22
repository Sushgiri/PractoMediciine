package com.product.shopping.entity;


import jakarta.validation.constraints.Positive;
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
@Document(collection = "MedicineOrders")
@Data
public class Order {
    @Id

    private  String  id;

    private String buyerid;
    private int quantity;
    private String medicineId;
    private String orderdate;
    private boolean paid;
}
