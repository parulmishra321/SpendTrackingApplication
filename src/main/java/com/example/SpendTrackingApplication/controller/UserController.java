package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.business.RegistrationService;
import com.example.SpendTrackingApplication.business.UserService;
import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.dao.UserWalletRepository;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.entity.UserWallet;
import com.example.SpendTrackingApplication.request.RegistrationRequest;
import com.example.SpendTrackingApplication.response.UserResponse;
import com.example.SpendTrackingApplication.response.UserWalletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;


    @PostMapping("/registration")
    public void register(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.register(registrationRequest);
    }

    @PutMapping("/user/update/{username}")
    public void updateProfile(@RequestBody RegistrationRequest registrationRequest,@PathVariable String username ) throws ValidationException {
        userService.updateProfile(registrationRequest,username);
    }

    @GetMapping("/user/balance/{id}")
    public UserWalletResponse viewWallet(@PathVariable(name = "id") String id) {
        return userService.viewWallet(id);
    }
}
