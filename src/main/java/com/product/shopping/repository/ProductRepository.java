package com.product.shopping.repository;

import com.product.shopping.entity.Order;
import com.product.shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//public interface Prodcutrepo extends JpaRepository<Product,Integer> {
//}
@Repository
public interface ProductRepository extends MongoRepository<Product,Integer>{
//    List<Order> findByproductId(long id);

}