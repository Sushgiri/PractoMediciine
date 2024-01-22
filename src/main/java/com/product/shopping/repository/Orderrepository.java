package com.product.shopping.repository;

import com.product.shopping.entity.Medicine;
import com.product.shopping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Orderrepository extends MongoRepository<Order ,String> {
    List<Order> findByMedicineId(String medicineId);
}
