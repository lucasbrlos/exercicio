package com.leodsc.blog.controller;

import com.leodsc.blog.model.UserModel;
import com.leodsc.blog.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @PostMapping("/registrar")
    public ResponseEntity<UserModel> newAccount(@RequestBody UserModel user) {
        return userService.createNewUser(user);
    }

//    @PostMapping("/login")
//    public void /*ResponseEntity<UserModel>*/ loginUser(@RequestBody UserModel user) {
//        System.out.println(user);
//    }
}
