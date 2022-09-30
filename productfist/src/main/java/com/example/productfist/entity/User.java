package com.example.productfist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name = "";
    private String password = "";
    private String email = "";
    private String address = "";
    private String birthday = "";
    private String createBy = "";
    private String deleteBy = "";
    private Long createAt = Long.MIN_VALUE;
    private Long updateAt = Long.MIN_VALUE;
    private Long deleteAt = Long.MIN_VALUE;
    @ManyToMany
    Collection<Role> roles = new ArrayList<>();

}
