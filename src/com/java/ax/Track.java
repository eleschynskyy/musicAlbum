package com.java.ax;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

public class Track implements Comparable<Track> {

	private int id;
	private String singer;
	private String title;
	private String duration;

	public int getId() {
		return id;
	}

	public Track setId(String id) {
		this.id = Integer.valueOf(id);
		return this;
	}

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
	
	public int getDurationInSeconds() {
		String durationAsString = this.getDuration();
		int durationInSeconds = 0;
		Pattern durationPattern = Pattern.compile("(\\d\\d):(\\d\\d)");
		Matcher durationMatcher = durationPattern.matcher(durationAsString);
		if (durationMatcher.matches()) {
			int minutes = Integer.valueOf(durationMatcher.group(1));
			int seconds = Integer.valueOf(durationMatcher.group(2));
			durationInSeconds = minutes * 60 + seconds;
		} else {
			System.out.println("Couldn't convert " + durationAsString + " properly.");
			throw new RuntimeException("Unsupported format for duration");
		}
		return durationInSeconds;
	}

	@Override
	public int compareTo(Track t) {
		return this.id > t.id ? 1 : (this.id < t.id ? -1 : 0);
	}

	public static class OrderByTitle implements Comparator<Track> {

		@Override
		public int compare(Track t1, Track t2) {
			return t1.title.compareTo(t2.title);
		}
	}
	
	public static class OrderByDuration implements Comparator<Track> {

		@Override
		public int compare(Track t1, Track t2) {
			return t1.getDurationInSeconds() - t2.getDurationInSeconds();
		}

	}

}
