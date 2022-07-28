package com.example.registrationlogin.service;

import com.example.registrationlogin.dao.entity.UserEntity;
import com.example.registrationlogin.dto.UserRegistrationDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity save(UserRegistrationDto userRegistrationDto);
}
