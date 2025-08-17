package com.example.TuneHubApp2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHubApp2.Entity.Playlist;
import com.example.TuneHubApp2.Entity.Songs;
import com.example.TuneHubApp2.Reposoteries.SongsReposotories;


@Service
public class SongsServiceImplementation implements SongsService{

	@Autowired
    SongsReposotories songrepo;

    @Override
    public String addSongs(Songs song) {
        songrepo.save(song);
        return "song is added";
    }

    @Override
    public boolean songExists(String name) {
        return songrepo.findByName(name) != null;
    }

    @Override
    public List<Songs> fetchAllSongs() {
        return songrepo.findAll();
    }

	
	
}
