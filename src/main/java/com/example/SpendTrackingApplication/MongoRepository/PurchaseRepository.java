package com.example.SpendTrackingApplication.MongoRepository;

import com.example.SpendTrackingApplication.model.Purchase;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PurchaseRepository extends MongoRepository<Purchase,String>{
    //List<Document> findList();
}


