package com.springtest.fullbackend.controller;

import com.springtest.fullbackend.exception.UserNotFoundException;
import com.springtest.fullbackend.model.User;
import com.springtest.fullbackend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepo.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    User getuserByID(@PathVariable Long id){
        return userRepo.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }


    @PutMapping("/user/{id}")
    User getUserBtId(@RequestBody User newUser,@PathVariable Long id){
    return userRepo.findById(id)
            .map(user->{
                user.setName(newUser.getName());
                user.setUsername(newUser.getUsername());
                user.setEmail(newUser.getEmail());
                return  userRepo.save(user);
            }).orElseThrow(()-> new UserNotFoundException(id));
    }



    @DeleteMapping("/user/{id}")
    String  deleteUser(@PathVariable Long id){
        if (!userRepo.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepo.deleteById(id);
        return "User with ID "+id+"Has Been Deleted SucessFully";

    }

}
