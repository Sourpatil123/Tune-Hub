package com.example.TuneHubApp2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TuneHubApp2.Entity.Playlist;
import com.example.TuneHubApp2.Entity.Songs;
import com.example.TuneHubApp2.Service.PlaylistService;
import com.example.TuneHubApp2.Service.SongsService;



@Controller
public class SongsController {

	@Autowired
    SongsService sserv;

    @Autowired
    PlaylistService pserv;

    @RequestMapping("/addsongs")
    public String addSongs(@ModelAttribute Songs song) {
        boolean songStatus = sserv.songExists(song.getName());
        if(songStatus==false) {
            sserv.addSongs(song);
        } else {
            return "addsongfail";
        }
        return "songsucess";
    }

    @GetMapping("/map-viewsongs")
    public String viewsongs(Model model) {
        List<Songs> songList = sserv.fetchAllSongs();
        List<Playlist> playlistList = pserv.fetchAllPlaylists();
        model.addAttribute("songList", songList);
        model.addAttribute("playlistList", playlistList);
        return "displaysongs";
    }

    @GetMapping("/viewsongs")
    public String viewCustomerSong(Model model) {
        boolean primeCustomerStatus = true; // false for payment
        if (primeCustomerStatus) {
            List<Songs> songList = sserv.fetchAllSongs();
            model.addAttribute("songList", songList);
            return "displaysongs";
        } else {
            return "makepayment";
        }
    }
		
}
