package com.example.productfist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  int idCategory;
    private String  name = "";
    private String description = "";
    private Long createAt = Long.MIN_VALUE;
    private String createBy = "";
    private Long deleteAt= Long.MIN_VALUE;

}
