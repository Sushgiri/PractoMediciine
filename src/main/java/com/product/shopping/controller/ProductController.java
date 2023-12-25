package com.product.shopping.controller;

import com.product.shopping.dto.Productdto;
import com.product.shopping.entity.Order;
import com.product.shopping.entity.Product;
import com.product.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("shopping/product")
public class ProductController {
   //http://localhost:8080/shopping/product
    @Autowired
    private ProductService service;




@PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Productdto> createproduct(@RequestBody @Valid Product product){
        Productdto createproduct = service.createproduct(product);
      return  new ResponseEntity<>(createproduct, HttpStatus.OK);
    }

       // Method for inserting multiple record at once
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/many")
    public ResponseEntity<String> createproduct(@RequestBody @Valid List<Product> products, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    service.createmultiple(products);
        return new  ResponseEntity<>("Prodcuts are saved",HttpStatus.OK);
    }


//htto:localhost:8080/shopping/product/productId



//    @DeleteMapping("/OrderId")
//    public ResponseEntity<String> deleteorder( @PathVariable long Orderid){
//
//        service.deleteorder(Orderid);
//    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteproduct(@PathVariable int id){
        service.deleteproduct(id);
        return new ResponseEntity<>("Product is Deleted",HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Productdto>> getallpost(){
       List<Productdto> getallproducts = service.getall();

       return new ResponseEntity<>(getallproducts,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateproduct(@PathVariable int  id, @RequestBody @Valid Product product){

            service.update(id,product);

            return new ResponseEntity<>("Product is updated",HttpStatus.OK);
    }




}
