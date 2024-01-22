package com.product.shopping.dto;

import lombok.Data;


@Data
public class StripeTokenDto {



    private String cardNumber;
    private String expMonth;
    private String expYear;
    private String cvc;

}
