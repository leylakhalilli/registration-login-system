package com.example.registrationlogin.service;

import com.example.registrationlogin.dto.UserRegistrationDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
}
