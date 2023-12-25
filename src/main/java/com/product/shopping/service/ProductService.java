package com.product.shopping.service;

import com.product.shopping.dto.Productdto;
import com.product.shopping.entity.Order;
import com.product.shopping.entity.Product;
import com.product.shopping.exception.Invalidentries;
import com.product.shopping.exception.OutOfStockException;
import com.product.shopping.exception.ResourceNotFoundException;
import com.product.shopping.repository.Orderrepo;
import com.product.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class ProductService {



    @Autowired
    private  Orderrepo orderrepo;

    @Autowired
    private ProductRepository prodcutrepo;




    public Productdto createproduct(Product  product){
       Product save = prodcutrepo.save(product);
        Productdto fetcheddto = maptodto(save);
        return fetcheddto;
    }

    public void deleteproduct(int id){

        if(prodcutrepo.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Product Not Found With id" + id);
        }
            prodcutrepo.deleteById(id);
    }

    public Productdto maptodto( Product product){
        Productdto dto = new Productdto();
        dto.setId((int) product.getId());
        dto.setProductName(product.getProductName());
        dto.setCost(product.getCost());
        dto.setStock(product.getStock());

        return dto;
    }

    public List<Productdto> getall() {

        List<Product>  products= prodcutrepo.findAll();

        List<Productdto> dtos = products.stream().map(p->maptodto(p)).collect(Collectors.toList());

        return dtos;
    }

    public void update(int id, Product product) {
        if(prodcutrepo.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Product Not Found With id" + id);
        }
        prodcutrepo.save(product);

    }

    public void placeorder(long ProductId,Order order) {
        Product product = prodcutrepo.findById((int) ProductId).orElseThrow(
                ()-> new ResourceNotFoundException("product not found with id:"+ProductId)
        );


        Order savingorder = new Order();

        if(product.getStock()< order.getItems()){
            throw  new OutOfStockException("We Can't Accept Your Order as we are running out  of stock, we will notify you when stock will be availble");
        }
        else {
            savingorder.setId(order.getId());
            savingorder.setItems(order.getItems());
            savingorder.setReview(order.getReview());
            savingorder.setBuyer(order.getBuyer());
            List<Order> orders = new ArrayList<>();
            product.setProductName(product.getProductName());
            product.setCost(product.getCost());
            product.setId(product.getId());
             product.setStock(product.getStock()-order.getItems());

             prodcutrepo.save(product);
            orders.add(savingorder);
            savingorder.setProduct(product);

            orderrepo.save(savingorder);

        }




    }

    public void deleteorder(long orderid) {
//        if(orderrepo.findById(orderid).isEmpty()) {
//            throw new ResourceNotFoundException("Product Not Found With id" + orderid);
//        }

    }



    public String createmultiple(List<Product> products) {
        List<Product> fetched = new ArrayList<>();
        List<Long> returned = new ArrayList<>();

        fetched.addAll(products);
        int count =0;
        for(Product filtered:fetched){
            if(filtered.getId()==0){
                throw  new ResourceNotFoundException("Id of onr of a product is not enterd ");
            }
            if(filtered.getProductName()==null){
                throw  new ResourceNotFoundException("Productname is empty of product with id: "+filtered.getId());
            } if(filtered.getStock()==0){
                throw  new ResourceNotFoundException("Stock data is missing for prodcut with id: "+filtered.getId());
            } if(filtered.getCost()==0) {
                throw new ResourceNotFoundException("Cost is not entered for product with id: " + filtered.getId());
            }
            count++;
            List<Product> ids = new ArrayList<>();
            ids.addAll(fetched);
            for(Product fetchedids:ids){
                returned.add(fetchedids.getId());
            }
        }

        if(count != 0){
            prodcutrepo.saveAll(products);
            return "products are Saved"+returned;
        }

       return  null;
    }
}
