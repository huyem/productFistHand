package com.example.productfist.controller;

import com.example.productfist.entity.User;
import com.example.productfist.service.UserServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserServiceItf userServiceItf;

    @GetMapping("/Users")
    public ResponseEntity<List<User>>  getListUser(){
        return ResponseEntity.ok().body(
                userServiceItf.getListUser()
        );
    }
}
