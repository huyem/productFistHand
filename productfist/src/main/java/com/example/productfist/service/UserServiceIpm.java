package com.example.productfist.service;

import com.example.productfist.entity.User;
import com.example.productfist.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceIpm implements UserServiceItf, UserDetailsService {
    @Autowired
    UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<User> getListUser() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id_user) {

    }

    @Override
    public List<User> searchUser() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userE = userRepo.findByName(username);
        if (userE == null) {
            log.error("User not found ");
            throw new UsernameNotFoundException("User not found");
        } else {
            log.info("Id is {}", userE.getId());
            log.info("User is {}", userE.getName());

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userE.getRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
        });

        return new org.springframework.security.core.userdetails.User(userE.getName(), userE.getPassword(), authorities);
    }
}
