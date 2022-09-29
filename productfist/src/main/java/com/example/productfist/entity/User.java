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

    private String nameUser = "";
    private String emailUser = "";
    private String addressUser = "";
    private String birthday = "";
    private String createBy = "";
    private String deleteBy = "";
    private Long createAt = Long.MAX_VALUE;
    private Long updateAt = Long.MIN_VALUE;
    private Long deleteAt = Long.MIN_VALUE;
    @ManyToMany
    Collection<Role> roles = new ArrayList<>();

}
