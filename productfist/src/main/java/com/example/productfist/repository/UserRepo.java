package com.example.productfist.repository;

import com.example.productfist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User ,Long> {
    User findByName(String name);

}
