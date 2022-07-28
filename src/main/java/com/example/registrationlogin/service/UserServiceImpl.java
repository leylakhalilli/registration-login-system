package com.example.registrationlogin.service;

import com.example.registrationlogin.dao.entity.RoleEntity;
import com.example.registrationlogin.dao.entity.UserEntity;
import com.example.registrationlogin.dao.repository.UserRepository;
import com.example.registrationlogin.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public UserEntity save(UserRegistrationDto userRegistrationDto) {
        UserEntity userEntity = new UserEntity(userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(),
                Arrays.asList(new RoleEntity("ROLE_USER")));

        return userRepository.save(userEntity);
    }


}
