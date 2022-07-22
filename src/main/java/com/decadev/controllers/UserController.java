package com.decadev.controllers;

import com.decadev.entities.User;
import com.decadev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public User findById(@PathVariable(value = "id") String id) {
        return userRepository.findById(id);
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PutMapping("{id}")
    public String update(@PathVariable(value = "id") String id, @RequestBody User user) {
        return userRepository.update(id, user);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable(value = "id") String id) {
        return userRepository.delete(id);
    }


}
