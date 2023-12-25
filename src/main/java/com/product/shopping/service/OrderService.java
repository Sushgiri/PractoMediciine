package com.product.shopping.service;

import com.product.shopping.entity.Order;

import com.product.shopping.entity.Product;
import com.product.shopping.exception.ResourceNotFoundException;
import com.product.shopping.repository.Orderrepo;
import com.product.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

@Autowired
private Orderrepo orderrepo;

@Autowired
private ProductRepository productRepository;
public List<Order> readall(long id){
    productRepository.findById((int) id).orElseThrow(
            ()-> new ResourceNotFoundException("No Order for product with id"+ id)
    );
    List<Order> byproductId = orderrepo.findByproductId((int) id);
    return byproductId;

}
}
