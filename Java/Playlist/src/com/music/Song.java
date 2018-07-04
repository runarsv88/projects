package com.music;

/**
 * Created by rsverrisson on 25-06-2018.
 */
public class Song {
    private String title;
    private String duration;

    public Song(String title, String duration){
        this.title = title;
        this.duration = duration;
    }

    public Song(String title) {
        this.title = title;
        this.duration = "N/A";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void printSong(){
        System.out.println(title + " " + duration);
    }
}
