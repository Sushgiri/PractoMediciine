package com.product.shopping.controller;

import com.product.shopping.dto.Orderdto;
import com.product.shopping.entity.Order;
import com.product.shopping.exception.ResourceNotFoundException;
import com.product.shopping.repository.MedicineRepository;
import com.product.shopping.service.OrderService;
import com.product.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//http://localhost:8080/shopping?productid=
@RestController
@RequestMapping("order/api")
public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    private ProductService productServiceservice;

    @Autowired
    private MedicineRepository medicineRepository;
//http://localhost:8089/order/api/
//                  @PreAuthorize("hasRole('USER')")
                  @GetMapping("/{medicineId}/{buyerId}")
                  public  ResponseEntity<?> orderplacing(@PathVariable  String medicineId,@PathVariable String buyerId, @Valid  @RequestBody Orderdto order, BindingResult bindingResult){
                      if(bindingResult.hasErrors()){
                      }
                      String placeorder = productServiceservice.placeorder(medicineId, buyerId, order);
                      return new ResponseEntity<>(placeorder,HttpStatus.OK);

                  }
//                  @PreAuthorize("hasRole('ADMIN')")
                  @GetMapping("/{medicineId}")
                  public ResponseEntity<?> readall(@PathVariable String  medicineId){
                      List<Order> readall = service.readall(medicineId);
                      if(readall.isEmpty()){
                          return new ResponseEntity<>("There are No Orders with product of id:" + medicineId,HttpStatus.NOT_FOUND);
                      }
                      return new ResponseEntity<>(readall,HttpStatus.OK);
                  }


}
