package com.java.ax;

import java.util.ArrayList;
import java.util.Collections;

public class Album {

	private String title;
	private ArrayList<Track> tracks;

	public Album(String title) {
		this.title = title;
		this.tracks = new ArrayList<Track>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public void addTrack(Track track) {
		tracks.add(track);
	}

	public void sortByDefault() {
		Collections.sort(tracks);
	}
	
	public void sortByTitle() {
		Collections.sort(tracks, new Track.OrderByTitle());
	}

	public void sortByDuration() {
		Collections.sort(tracks, new Track.OrderByDuration());
	}

}
