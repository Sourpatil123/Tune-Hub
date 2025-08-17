package com.example.TuneHubApp2.Entity;

import java.util.List;
import jakarta.persistence.*;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Playlist {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	    private String name;

	    // Corrected mapping: Playlist has many songs
	    @ManyToMany
	    @JoinTable(
	        name = "playlist_songs",
	        joinColumns = @JoinColumn(name = "playlist_id"),
	        inverseJoinColumns = @JoinColumn(name = "song_id")
	    )
	    private List<Songs> songs;

	    public Playlist() {}

	    public Playlist(int id, String name, List<Songs> songs) {
	        this.id = id;
	        this.name = name;
	        this.songs = songs;
	    }

	    // Getters and setters
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public List<Songs> getSongs() { return songs; }
	    public void setSongs(List<Songs> songs) { this.songs = songs; }

	    @Override
	    public String toString() {
	        return "Playlist [id=" + id + ", name=" + name + ", songs=" + songs + "]";
	    }	
}
