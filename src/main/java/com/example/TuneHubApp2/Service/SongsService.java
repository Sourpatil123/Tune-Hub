package com.example.TuneHubApp2.Service;



import java.util.List;

import com.example.TuneHubApp2.Entity.Playlist;
import com.example.TuneHubApp2.Entity.Songs;



public interface SongsService {
	
	String addSongs(Songs song);
    boolean songExists(String name);
    List<Songs> fetchAllSongs();
   // void deleteSongById(Long id);
	
	
	
	 

}
