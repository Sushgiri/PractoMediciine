package com.product.shopping.repository;

import com.product.shopping.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.SplittableRandom;

//public interface Prodcutrepo extends JpaRepository<Product,Integer> {
//}
@Repository
public interface MedicineRepository extends MongoRepository<Medicine, String>{
      Medicine findByMedicineId(String medicineId);

}