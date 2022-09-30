package com.example.productfist;

import com.example.productfist.entity.Role;
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
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserServiceItf userService) {
        return args -> {
//            userService.saveRole(new Role(null, "ROLE_USER", "", "",
//                    "",
//                    Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE));
//            userService.saveRole(new Role(null, "ROLE_ADMIN", "", "",
//                    "",
//                    Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE));
//            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN", "", "",
//                    "",
//                    Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE));
//            userService.saveUser(new User(null, "Khôngten",
//                    "A@1qazxc",
//                    "heloo@gmail.com", "NULL ", "", "",
//                    "Long.MIN_VALUE",
//                    Long.MIN_VALUE,
//                    Long.MIN_VALUE, Long.MIN_VALUE, new ArrayList<>()));
//            userService.addRoleToUser("Khôngten","ROLE_USER");
//            userService.addRoleToUser("Khôngten","ROLE_ADMIN");
//            userService.addRoleToUser("huyem1003","ROLE_SUPER_ADMIN");

        };
    }
}
