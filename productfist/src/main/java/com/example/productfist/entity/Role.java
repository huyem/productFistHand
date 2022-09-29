package com.example.productfist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName = "";
    private String role_description = "";  private String createBy="";
    private String deleteBy="";
    private Long createAt =Long.MIN_VALUE;
    private Long updateAt = Long.MIN_VALUE;
    private Long deleteAt = Long.MIN_VALUE;



}
