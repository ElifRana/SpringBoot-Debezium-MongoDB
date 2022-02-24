package com.example.springbootdebeziummongodb.controller;

import com.example.springbootdebeziummongodb.model.User;
import com.example.springbootdebeziummongodb.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/mongodb")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {//@pathVariable
        return userService.getUser(id);
    }

    @PostMapping("/user/save")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }

    @GetMapping("user/allUser")
    public List<User> allUser() {
        return userService.allUser();
    }
}
