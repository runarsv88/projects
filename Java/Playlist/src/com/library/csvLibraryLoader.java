package com.library;

import com.music.Album;
import com.music.Song;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by rsverrisson on 25-06-2018.
 */
public class csvLibraryLoader {
    public static ArrayList<Album> loadLibrary(String filename) throws IOException {
        String pathToLibrary = "./resources/" + filename;

        File libraryFile = new File(pathToLibrary);
        FileReader reader = new FileReader(libraryFile);
        BufferedReader bufferedReader =  new BufferedReader(reader);

        String line;
        ArrayList<Album> albums = new ArrayList<>();
        while ( ( line = bufferedReader.readLine()) != null ) {
            String[] splitLine = line.split(";");
            String artist = splitLine[0].trim();
            String title = splitLine[1].trim();
            String[] tracks = splitLine[2].split(",");
            ArrayList<Song> trackList = new ArrayList<>();
            for (String track : tracks){
                trackList.add(new Song(track.trim()));
            }
            albums.add(new Album(artist, title, trackList));
        }
        return albums;
    }
}
