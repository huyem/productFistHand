package com.example.productfist.controller;

import com.example.productfist.entity.Role;
import com.example.productfist.entity.User;
import com.example.productfist.service.UserServiceItf;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> registerUser(@RequestBody User userE) {
        return ResponseEntity.ok().body(userServiceItf.saveUser(userE));
    }
    @PostMapping ("/user/save")
    public ResponseEntity<User> saverUser(@RequestBody User userE) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.ok().body(userServiceItf.saveUser(userE));
    }
    @PostMapping ("/role/save")
    public ResponseEntity<Role> saverUser(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userServiceItf.saveRole(role));
    }
    @PostMapping ("/role/addtouser")
    public ResponseEntity<?> addRoleTouser(@RequestBody RoleToUserForm form) {

        userServiceItf.addRoleToUser(form.getUseremail(),form.getRoleuser());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm{
    private String useremail;
    private String roleuser;
}
