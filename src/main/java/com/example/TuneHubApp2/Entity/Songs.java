package com.example.TuneHubApp2.Entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Songs {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	    private String name;
	    private String artist;
	    private String genre;
	    private String link;

	    // Bidirectional mapping with Playlist
	    @ManyToMany(mappedBy = "songs")
	    private List<Playlist> playlists;

	    public Songs() {}

	    public Songs(int id, String name, String artist, String genre, String link, List<Playlist> playlists) {
	        this.id = id;
	        this.name = name;
	        this.artist = artist;
	        this.genre = genre;
	        this.link = link;
	        this.playlists = playlists;
	    }

	    // Getters and setters
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getArtist() { return artist; }
	    public void setArtist(String artist) { this.artist = artist; }

	    public String getGenre() { return genre; }
	    public void setGenre(String genre) { this.genre = genre; }

	    public String getLink() { return link; }
	    public void setLink(String link) { this.link = link; }

	    public List<Playlist> getPlaylists() { return playlists; }
	    public void setPlaylists(List<Playlist> playlists) { this.playlists = playlists; }

	    @Override
	    public String toString() {
	        return "Songs [id=" + id + ", name=" + name + ", artist=" + artist +
	               ", genre=" + genre + ", link=" + link + "]";
	    }

}
