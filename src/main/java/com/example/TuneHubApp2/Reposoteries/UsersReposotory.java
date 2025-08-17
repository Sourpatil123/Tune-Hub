package com.example.TuneHubApp2.Reposoteries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubApp2.Entity.Users;

public interface UsersReposotory extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);
}
