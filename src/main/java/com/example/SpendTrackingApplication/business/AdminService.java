package com.example.SpendTrackingApplication.business;

import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;

    public List<UserResponse> getUsers(){
        List<UserResponse> list= new ArrayList<>();
        List<User> response= (List<User>) userRepository.findAll();
        response.forEach(element -> {
            UserResponse userResponse= new UserResponse();
            BeanUtils.copyProperties(element, userResponse);
            list.add(userResponse);
        });
        return list;
    }
}
