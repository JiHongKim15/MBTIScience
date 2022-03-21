package com.mbti.user.user.user.controller;


import com.mbti.user.user.user.entity.User;
import com.mbti.user.user.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Valid
@RestController
@RequestMapping("/user")
public record UserController(UserService userService) {

    @GetMapping
    public User retrieveUserById(@RequestParam String id){
        return userService.retrieveUserById(id);
    }

    /**
     * Method: saveUser
     * Description: 회원가입
     * @param user
     */
    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PatchMapping
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody String id){
        userService.deleteUser(id);
    }





}
