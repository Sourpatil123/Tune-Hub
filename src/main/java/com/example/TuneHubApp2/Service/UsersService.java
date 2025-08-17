package com.example.TuneHubApp2.Service;

import com.example.TuneHubApp2.Entity.Users;

public interface UsersService {
	
	
String addUser(Users user);
boolean emailExists(String email);
boolean validateUser(String email, String password);
String getRole(String email);

}
