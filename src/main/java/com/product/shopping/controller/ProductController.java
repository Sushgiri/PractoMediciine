package com.product.shopping.controller;
import com.product.shopping.dto.Medicinedto;
import com.product.shopping.entity.Medicine;
import com.product.shopping.entity.Order;
import com.product.shopping.entity.main;
import com.product.shopping.repository.MedicineRepository;
import com.product.shopping.repository.Orderrepository;
import com.product.shopping.service.OrderService;
import com.product.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("medicine/api")
public class ProductController {
   //http://localhost:8089/medicine/api
    @Autowired
    private ProductService service;


    @Autowired
    private MedicineRepository medicineRepository;


    @Autowired
    private Orderrepository orderrepo;
    @Autowired
    private OrderService orderservice;


//@PreAuthorize("hasRole('ADMIN)")
    @PostMapping
    public ResponseEntity<Medicinedto> createproduct(@RequestBody @Valid Medicine medicine){
    Medicinedto createproduct = service.createproduct(medicine);
      return  new ResponseEntity<>(createproduct, HttpStatus.OK);
    }
    //http://localhost:8089/medicine/api
       // Method for inserting multiple record at once

    //http://localhost:8089/medicine/api/many
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/many")
    public ResponseEntity<String> createproduct(@RequestBody @Valid List<Medicine> medicines, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    service.createmultiple(medicines);
        return new  ResponseEntity<>("Prodcuts are saved",HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{medicineId}")
    public  ResponseEntity<String> deleteproduct(@PathVariable String medicineId){
        Medicine byMedicineId = medicineRepository.findByMedicineId(medicineId);
        service.deleteproduct(byMedicineId.getId());
        return new ResponseEntity<>("Product is Deleted",HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/med")
    public ResponseEntity<List<Medicinedto>> getallpost(){
       List<Medicinedto> getallproducts = service.getall();

       return new ResponseEntity<>(getallproducts,HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{medicineId}")
    public ResponseEntity<?> updateproduct(@PathVariable String medicineId, @RequestBody @Valid Medicine product){

            service.update(medicineId,product);

            return new ResponseEntity<>("Product is updated",HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getall (){

        List<Medicine> getall = medicineRepository.findAll();
        List<Order> all = orderrepo.findAll();
main main = new main();
main.setProducts(getall);
main.setOrders(all);
return new ResponseEntity<>(main,HttpStatus.OK);



    }


}
