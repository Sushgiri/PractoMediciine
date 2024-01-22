package com.product.shopping.service;

import com.product.shopping.config.RestemplateConfig;
import com.product.shopping.controller.PaymentController;
import com.product.shopping.dto.Medicinedto;

import com.product.shopping.dto.Orderdto;
import com.product.shopping.entity.Medicine;
import com.product.shopping.entity.Order;

import com.product.shopping.exception.InvalidInputException;
import com.product.shopping.exception.OutOfStockException;
import com.product.shopping.exception.ResourceNotFoundException;
import com.product.shopping.repository.MedicineRepository;
import com.product.shopping.repository.Orderrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



@Service
public class ProductService {



    @Autowired
    private Orderrepository orderrepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private RestemplateConfig restemplateConfig;
    @Autowired
    private PaymentController paymentController;

    @Autowired
    private Order orderstatus;



    public Medicinedto createproduct(Medicine medicine){
          String mId = UUID.randomUUID().toString();
          medicine.setMedicineId(mId);
        Medicine save = medicineRepository.save(medicine);
        Medicinedto fetcheddto = maptodto(save);
        return fetcheddto;
    }
    public void deleteproduct(String medicineId){

        if(medicineRepository.findByMedicineId(medicineId)== null) {
            throw new ResourceNotFoundException("Product Not Found With id" + medicineId);
        }
        medicineRepository.deleteById(medicineId);
    }
    public Medicinedto maptodto( Medicine medicine){
        Medicinedto dto = new Medicinedto();
        dto.setName(medicine.getName());
        dto.setManufacturer(medicine.getManufacturer());
        dto.setMedicineId(medicine.getMedicineId());
        dto.setPrice(medicine.getPrice());
        dto.setStock(medicine.getStock());
        return dto;
    }
    public List<Medicinedto> getall() {
        List<Medicine>  availablemedicines= medicineRepository.findAll();
        List<Medicinedto> dtos = availablemedicines.stream().map(p->maptodto(p)).collect(Collectors.toList());
        return dtos;
    }
    public void update(String medicineId, Medicine medicine) {
        if(medicineRepository.findByMedicineId(medicineId)== null) {
            throw new ResourceNotFoundException("medicine  Not Found With id" + medicineId);
        }
     medicineRepository.save(medicine);
    }
    public String placeorder(String MedicineId,String buyerId, Orderdto corder) {
        Medicine  medicine= medicineRepository.findByMedicineId(MedicineId);
        if(medicine ==null){
            throw  new ResourceNotFoundException("Medicine not found");
        }
        if(medicine.getStock()< corder.getQuantity()){
            throw  new OutOfStockException("We Can't Accept Your Order as we are running out  of stock, we will notify you when stock will be availble");
        }
//        //restemplateConfig.getRestTemplate().postForEntity("http://localhost:8090/", StripeTokenDto)
//      if(cardresponse != null){
//          restemplateConfig.getRestTemplate().getForObject("http://localhost:9095/payments/charge",String.class);
//      }
        Order order = new Order();
        String id = UUID.randomUUID().toString();
        order.setId(id);
        order.setMedicineId(medicine.getMedicineId());
        order.setQuantity(corder.getQuantity());  // Make sure this value is correctly obtained
      if(corder.getQuantity() == 0) {
          return "please enter quantity ";
      }
        order.setBuyerid(buyerId);
        Date date = new Date();
        String todayDate = date.toString();
        order.setOrderdate(todayDate);
        orderstatus.setPaid(false);
        orderstatus.setId(order.getId());
        orderstatus.setOrderdate(order.getOrderdate());
        orderstatus.setQuantity(order.getQuantity());
        orderstatus.setBuyerid(order.getBuyerid());
        orderstatus.setMedicineId(order.getMedicineId());
    return"Enter Payment Card Details:     http://localhost:8089/medicine/payment/"+buyerId;
        }

    public void deleteorder(long orderid) {
//        if(orderrepo.findById(orderid).isEmpty()) {
//            throw new ResourceNotFoundException("Product Not Found With id" + orderid);
//        }
    }
    public String createmultiple(List<Medicine> medicines) {
        List<Medicine> fetched = new ArrayList<>();
        List<String> meid= new ArrayList<>();
        fetched.addAll(medicines);
        int count =0;
        for(Medicine filtered:fetched){
            if(filtered.getId().equals(null)){
                throw  new InvalidInputException("Id of onr of a product is not enterd ");
            }
            if(filtered.getName()==null){
                throw  new InvalidInputException("Productname is empty of product with id: "+filtered.getId());
            } if(filtered.getStock()==0){
                throw  new InvalidInputException("Stock data is missing for prodcut with id: "+filtered.getId());
            } if(filtered.getPrice()==0) {
                throw new InvalidInputException("Cost is not entered for product with id: " + filtered.getId());
            }
            count++;
            List<Medicine> ids = new ArrayList<>();
            for(Medicine id:ids){
                 String idss = UUID.randomUUID().toString();
                 id.setMedicineId(idss);
            }
            for(Medicine fetchedids:ids){
                meid.add(fetchedids.getMedicineId());
            }
        }
        if(count != 0){
          medicineRepository.saveAll(medicines);
            return "products are Saved"+meid;
        }
       return  null;
    }
}
