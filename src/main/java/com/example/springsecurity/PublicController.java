package com.example.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    PersonRepository personRepository;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @GetMapping("/welcome")
    public String welcome(){

        return "Welcome to PUBLIC area";
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepository.save(person);
        return "Student added";
    }
}
