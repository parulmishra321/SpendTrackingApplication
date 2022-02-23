package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.MongoRepository.PurchaseRepository;
import com.example.SpendTrackingApplication.model.Purchase;
import com.example.SpendTrackingApplication.utils.CommonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    //private MongoOperations mongoOperations = new MongoTemplate(new MongoClient(), "local");

    @Autowired
    PurchaseRepository purchaseMongoRepository;

    @PostMapping(value = "/createPurchase")
    public String createPurchase(@RequestBody Purchase purchase)
    {
        CommonUtils.setCreateEntityFields(purchase);
        CommonUtils.setUpdateEntityFields(purchase);
        Purchase addPurchase = purchaseMongoRepository.save(purchase);
        return "New Purchase is made with ID:" + addPurchase.getPurchaseId();
    }

    @JsonIgnore
    @GetMapping(value = "/allPurchases")
    public List<Purchase> getAllPurchases(){
//        List<Purchase> response = new ArrayList<>();
//        Document query = new Document();
//        Document projection = new Document();
//        projection.put(_ID, 0);
//        List<Document> result = purchaseRepository.findList(Purchase, query, projection);

          List<Purchase> listOfPurchases = purchaseMongoRepository.findAll();
          return listOfPurchases;


    }

//    @GetMapping("/viewPurchases/{purchaseId}")
//    public ResponseEntity<Purchase> viewPurchaseById(@RequestParam(value = "id") String purchaseId){
//         Optional<Purchase> id = purchaseMongoRepository.findById(purchaseId);
//        if (id != null)
//        {
//            return new ResponseEntity<>(id, HttpStatus.OK);
//        }
//        System.out.println("There isn't any Purchase in Mongodb database with this ID: " + purchaseId);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
