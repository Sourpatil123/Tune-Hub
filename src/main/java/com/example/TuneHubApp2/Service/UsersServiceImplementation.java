package com.example.TuneHubApp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHubApp2.Entity.Users;
import com.example.TuneHubApp2.Reposoteries.UsersReposotory;



@Service
public class UsersServiceImplementation implements UsersService{

	@Autowired
    UsersReposotory urepo;

    @Override
    public String addUser(Users user) {
        urepo.save(user);
        return "user is created and saved";
    }

    @Override
    public boolean emailExists(String email) {
        return urepo.findByEmail(email) != null;
    }

    @Override
    public boolean validateUser(String email, String password) {
        Users user = urepo.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public String getRole(String email) {
        return urepo.findByEmail(email).getRole();
    }
}
