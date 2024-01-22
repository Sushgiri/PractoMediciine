package com.product.shopping.controller;

import com.product.shopping.config.RestemplateConfig;
import com.product.shopping.dto.PaymentRequestDto;
import com.product.shopping.dto.StripeTokenDto;
import com.product.shopping.entity.Order;
import com.product.shopping.repository.Orderrepository;
import com.product.shopping.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;

@RestController
@RequestMapping("/medicine/payment")

@Data
public class PaymentController {


    @Autowired
    private RestemplateConfig restemplateConfig;
    @Autowired
    private ProductService productservic;

    @Autowired
    private Orderrepository orderrepository;

 @Autowired
 private Order orderstatus;
//http://localhost:8089/medicine/payment/username
    @PostMapping("/{username}")
    public ResponseEntity<?> entercardatails(@PathVariable String username, @RequestBody StripeTokenDto stripeTokenDto){
        ResponseEntity<String> stringResponseEntity = restemplateConfig.getRestTemplate().postForEntity("http://localhost:8090/payments/card/token/" + username, stripeTokenDto, String.class);
          return new ResponseEntity<>("This is your token for payment:"+stringResponseEntity  +"\n"+ "Pay Now:   http://localhost:8089/payment/medicine/payment/charge/"+username, HttpStatus.OK);
    }
    @PostMapping("/charge/{username}")
    public ResponseEntity<?> enteramountcurrencytoken(@PathVariable String username, @RequestBody PaymentRequestDto paymentRequestDto){
        ResponseEntity<String> stringResponseEntity = restemplateConfig.getRestTemplate().postForEntity("http://localhost:8090/payments/charge" + username, paymentRequestDto, String.class);
     if(stringResponseEntity.equals("payment sucessful")){
          Order order1 = new Order();
          order1.setMedicineId(orderstatus.getMedicineId());
          order1.setId(orderstatus.getId());
          order1.setPaid(true);
          order1.setBuyerid(orderstatus.getBuyerid());
          order1.setOrderdate(orderstatus.getOrderdate());
          order1.setQuantity(orderstatus.getQuantity());
         orderrepository.save(order1);
     }
      return new ResponseEntity<>(stringResponseEntity,HttpStatus.OK);
    }




}
