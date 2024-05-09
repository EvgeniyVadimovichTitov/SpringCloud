package com.example.homework03.controllers;

import com.example.homework03.domain.User;
import com.example.homework03.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().addUserToList(user);
        return "User added from body!";
    }

    @GetMapping("/params/{name}/{email}/{age}")
    public  String userAddFromParam(@PathVariable String name, @PathVariable String email, @PathVariable int age) {
        service.processRegistration(name, email, age);
        return "User added from get-request!";
    }
}
