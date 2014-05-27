package com.java.main;

public class TestMusicAlbum {

	public static void main(String[] args) {
		AlbumManager albumManager = new AlbumManager();
		albumManager.printAlbumInfo();
		albumManager.sortByTitle();
		albumManager.printAlbumInfo();
	}

}
