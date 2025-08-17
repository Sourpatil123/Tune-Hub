package com.example.TuneHubApp2.Reposoteries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubApp2.Entity.Songs;

public interface SongsReposotories extends JpaRepository<Songs, Integer>{

	Songs findByName(String name);
}
