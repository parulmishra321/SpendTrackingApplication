package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.entity.UserWallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserWalletRepository extends CrudRepository<UserWallet,String>{

    @Query(value="From UserWallet where USER_ID=:id")
    UserWallet getUserWallet(@Param("id") String id);
}