package com.java.ax;

public class Track {

	private String singer;
	private String title;
	private String duration;

	public String getSinger() {
		return singer;
	}

	public Track setSinger(String singer) {
		this.singer = singer;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Track setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDuration() {
		return duration;
	}

	public Track setDuration(String duration) {
		this.duration = duration;
		return this;
	}

	public void printTrackInfo() {
		System.out.println("Singer: " + getSinger() + "\t" + "Title: "
				+ getTitle() + "\t" + "Duration: " + getDuration());
	}

}
