package com.study.springboot202010kkr.web.controller;

import com.study.springboot202010kkr.service.UserService;
import com.study.springboot202010kkr.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity.created(null).body(true);
    }
    @GetMapping("/user")
    public ResponseEntity<?> getUser(@PathVariable int userId){
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }
}
