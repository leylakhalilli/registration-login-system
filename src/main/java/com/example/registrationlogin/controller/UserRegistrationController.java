package com.example.registrationlogin.controller;

import com.example.registrationlogin.dto.UserRegistrationDto;
import com.example.registrationlogin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("userForm")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationPage(Model model) {
        model.addAttribute("userForm", new UserRegistrationDto());
        return "registration";
    }


//    @GetMapping
//    public String showRegistrationForm() {
//        return "registration";
//    }


    @PostMapping
    public String registerUser(@ModelAttribute("userForm") UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";

    }

}
