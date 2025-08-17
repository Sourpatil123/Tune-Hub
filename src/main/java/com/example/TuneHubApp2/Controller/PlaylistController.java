package com.example.TuneHubApp2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TuneHubApp2.Entity.Playlist;
import com.example.TuneHubApp2.Entity.Songs;
import com.example.TuneHubApp2.Service.PlaylistService;
import com.example.TuneHubApp2.Service.SongsService;


@Controller
public class PlaylistController {

	 @Autowired
	    PlaylistService pserv;

	    @Autowired
	    SongsService songserv;

	    @GetMapping("/map-createplaylist")
	    private String createPlaylist(Model model) {
	        List<Songs> songList = songserv.fetchAllSongs();
	        model.addAttribute("songList", songList);
	        return "createplaylist";
	    }

	    @PostMapping("/addplaylist")
	    public String addPlaylist(@ModelAttribute Playlist playlist, Model model) {
	        boolean isAdded = pserv.addPlayList(playlist.getName(), playlist);
	        if (isAdded) {
	            model.addAttribute("message", "Playlist created successfully!");
	            return "playlistsuccess";
	        } else {
	            model.addAttribute("errorMessage", "Playlist already exists!");
	            return "createplaylist";
	        }
	    }

}
