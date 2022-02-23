package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.business.AdminService;
import com.example.SpendTrackingApplication.business.ProductService;
import com.example.SpendTrackingApplication.request.ProductRequest;
import com.example.SpendTrackingApplication.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String home(){
        return "Welcome";
    }

    @PostMapping("/addProducts")
    public void addProduct(@RequestBody ProductRequest productRequest) {
        productService.product(productRequest);
    }

    @GetMapping("/getAllUsers")
    public List<UserResponse> getUsers()
    {
        List<UserResponse> listUsers = adminService.getUsers();
        return listUsers;
    }

}
