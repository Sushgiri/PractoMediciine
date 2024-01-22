package com.product.shopping.dto;

import lombok.Data;


@Data

public class PaymentRequestDto {
    private long amount;
    private String currency;
    private  String tokenId;

}
