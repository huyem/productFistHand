package com.example.productfist.service;

import com.example.productfist.entity.User;

import java.util.List;

public interface UserServiceItf {
    List<User> getListUser();
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(int id_user);
    List<User> searchUser();
}
