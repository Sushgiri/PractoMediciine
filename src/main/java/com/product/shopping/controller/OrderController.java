package com.product.shopping.controller;

import com.product.shopping.dto.Orderdto;
import com.product.shopping.entity.Order;
import com.product.shopping.exception.ResourceNotFoundException;
import com.product.shopping.service.OrderService;
import com.product.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//http://localhost:8080/shopping?productid=
@RestController
@RequestMapping("shopping/order")
public class OrderController {


    @Autowired
    private OrderService service;

    @Autowired
    private ProductService productServiceservice;

                  @PreAuthorize("hasRole('USER')")
                  @PostMapping
                  public  ResponseEntity<String> orderplacing(@RequestParam ("productId") long productId, @Valid  @RequestBody Order order, BindingResult bindingResult){
                      if(bindingResult.hasErrors()){

                      }
                      productServiceservice.placeorder(productId,order);
                      return new ResponseEntity<>("Order Placed For Product with id :"+productId, HttpStatus.OK);

                  }

                  @GetMapping("/{productid}")
                  public ResponseEntity<?> readall(@PathVariable long productid){
                      List<Order> readall = service.readall(productid);
                      if(readall.isEmpty()){
                          return new ResponseEntity<>("There are No Orders with product of id:" + productid,HttpStatus.NOT_FOUND);
                      }
                      return new ResponseEntity<>(readall,HttpStatus.OK);
                  }


}
