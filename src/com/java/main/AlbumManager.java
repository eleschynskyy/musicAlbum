package com.java.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

import com.java.ax.Album;
import com.java.ax.Track;

public class AlbumManager {

	private static final String DATA_FILE_ROOT = "resources";
	private static final String DATA_FILE_NAME = "music_album";
	private static final String DEFAULT_ALBUM_TITLE = "Default title";
	private static final String path;
	private static final Album album;
	private String sortedBy = "default";

	static {
		album = new Album(DEFAULT_ALBUM_TITLE);
		path = DATA_FILE_ROOT + File.separator + DATA_FILE_NAME + ".csv";
		File file = new File(path);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) {
					Map<String, String> record = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						record.put(keys[i], dataParts[i]);
					}
					Track track = new Track()
							.setSinger(record.get("singer"))
							.setTitle(record.get("track_title"))
							.setDuration(record.get("track_duration"));
					album.addTrack(track);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + path + " was not found.\n"
					+ e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + path + " file.\n"
					+ e.getStackTrace().toString());
		}
	}

	public void printAlbumInfo() {
		System.out.println("Album info is sorted by " + sortedBy + ".");
		System.out.println("-------------------------------------------------");
		System.out.println("Album title: " + getAlbumTitle());
		System.out.println("-------------------------------------------------");
		printAlbumTracks();
		System.out.println("-------------------------------------------------");
	}

	private void printAlbumTracks() {
		Iterator<Track> trackIterator = album.getTracks().iterator();
		while (trackIterator.hasNext()) {
			Track track = trackIterator.next();
			track.printTrackInfo();
		}
	}

	public String getAlbumTitle() {
		return album.getTitle();
	}

	public void sortByTitle() {
		sortedBy = "title";
		album.sortByTitle();
	}

}
