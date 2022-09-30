package com.example.productfist;

import com.example.productfist.entity.User;
import com.example.productfist.service.UserServiceItf;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ProductfistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductfistApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
//	@Bean
//	CommandLineRunner run(UserServiceItf userService){
//		return args -> {
//
//
//                userService.saveUser(new User(null,"huyem1003",
//                        "A@1qazxc",
//                       "huy em","rwere ","","",
//                        "Long.MIN_VALUE",
//                        Long.MIN_VALUE,
//                        Long.MIN_VALUE,Long.MIN_VALUE,new ArrayList<>()));
//
//
//		};
//	}
}
