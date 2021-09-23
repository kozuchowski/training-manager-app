package com.beef.beef.controller;

import com.beef.beef.model.User;
import com.beef.beef.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /user (after Application path)
public class MainController {

    private UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public String addNewUser (@RequestParam String login, @RequestParam String pass) {

        User n = new User();
        n.setLogin(login);
        n.setPassword(pass);
        userRepository.save(n);
        return "index";
    }





    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}