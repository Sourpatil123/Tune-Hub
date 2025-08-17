package com.example.TuneHubApp2.Reposoteries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubApp2.Entity.Playlist;

public interface PlaylistReposoteries extends JpaRepository<Playlist, Integer>{
	
	Optional<Playlist> findByName(String name);
}
