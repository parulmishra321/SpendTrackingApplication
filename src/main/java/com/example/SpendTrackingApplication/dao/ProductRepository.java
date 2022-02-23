package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,String> {

    @Query(value="From Product where category=:category")
    List<Product> viewProductsAccToCategory(@Param("category") String category);
}
