package com.example.productfist.repository;

import com.example.productfist.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
        Role findByRoleName(String role);
}
