package com.example.TuneHubApp2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navController {

	 @GetMapping("/map-register")
	    public String mapAddUsers() {
	        return "register";
	    }

	    @GetMapping("/map-login")
	    public String mapLoginUser() {
	        return "login";
	    }

	    @GetMapping("/map-songs")
	    public String addMapSong() {
	        return "addsongs";   // This looks for addsongs.html
	    }
}
