package com.example.TuneHubApp2.Service;

import java.util.List;

import com.example.TuneHubApp2.Entity.Playlist;
import com.example.TuneHubApp2.Entity.Songs;

public interface PlaylistService {

	
	 String createPlaylist(Playlist playlist);
	    boolean addPlayList(String name, Playlist playlist);
	    List<Playlist> fetchAllPlaylists();
}
