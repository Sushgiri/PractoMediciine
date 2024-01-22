package com.product.shopping.service;

import com.product.shopping.entity.Medicine;
import com.product.shopping.entity.Order;


import com.product.shopping.exception.ResourceNotFoundException;
import com.product.shopping.repository.MedicineRepository;
import com.product.shopping.repository.Orderrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

 @Autowired
private Orderrepository orderrepository;
@Autowired
private MedicineRepository productRepository;
public List<Order> readall(String medicineId){
    Medicine medicine = productRepository.findByMedicineId(medicineId);
    if(medicine == null){
        throw new ResourceNotFoundException("There is no medicine with id"+medicineId);
    }

    List<Order> byproductId = orderrepository.findByMedicineId(medicineId);
    return byproductId;
}
}
