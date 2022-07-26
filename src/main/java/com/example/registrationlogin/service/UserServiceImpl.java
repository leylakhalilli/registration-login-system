package com.example.registrationlogin.service;

import com.example.registrationlogin.dao.repository.UserRepository;
import com.example.registrationlogin.dto.UserRegistrationDto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER"))
                );

        return userRepository.save(user);
    }

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
}
