package com.music;

import java.util.ArrayList;

/**
 * Created by rsverrisson on 25-06-2018.
 */
public class Album {
    private String title;
    private String artist;
    private ArrayList<Song> trackList;

    public Album(String artist, String title, ArrayList<Song> trackList) {
        this.artist = artist;
        this.title = title;
        this.trackList = trackList;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getTrackList() {
        return trackList;
    }

    public String getTitle() {
        return title;
    }

    public void printAlbumShort() {
        System.out.println(artist + " - " + title);
    }

    public void printAlbum() {
        System.out.println("#####################");
        System.out.println("Artist: " + artist);
        System.out.println("Title: " + title);
        System.out.println("Track list: ");
        int counter = 0;
        for (Song song : trackList) {
            counter++;
            System.out.print(counter + ". ");
            song.printSong();
        }
        System.out.println("#####################");
    }
}
