package com.example.TuneHubApp2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TuneHubApp2.Entity.Users;
import com.example.TuneHubApp2.Service.UsersService;



@Controller
public class UsersController {

	@Autowired
    UsersService userv;

    @PostMapping("/register")
    public String addUser(Users user) {
        boolean userStatus = userv.emailExists(user.getEmail());
        if (!userStatus) {
            userv.addUser(user);
            System.out.println("User is added");
            return "registersucess";
        } else {
            return "registerfail";
        }
    }

    @PostMapping("/login")
    public String validateUser(@RequestParam String email, @RequestParam String password) {
        if (userv.validateUser(email, password)) {
            if (userv.getRole(email).equals("admin")) {
                return "adminhome";
            } else {
                return "customerhome";
            }
        } else {
            return "loginfail";
        }
    }
}
