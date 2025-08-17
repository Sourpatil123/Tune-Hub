package com.example.TuneHubApp2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHubApp2.Entity.Playlist;
import com.example.TuneHubApp2.Entity.Songs;
import com.example.TuneHubApp2.Reposoteries.PlaylistReposoteries;
import com.example.TuneHubApp2.Reposoteries.SongsReposotories;

@Service
public class PlaylistServiceImplementation implements PlaylistService{

	@Autowired
    PlaylistReposoteries prepo;

    @Override
    public String createPlaylist(Playlist playlist) {
        prepo.save(playlist);
        return "playlist is created";
    }

    @Override
    public boolean addPlayList(String name, Playlist playlist) {
        if (!prepo.findByName(name).isPresent()) {
            prepo.save(playlist);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Playlist> fetchAllPlaylists() {
        return prepo.findAll();
    }
	
}
