package com.library;

import java.io.IOException;
import java.util.ArrayList;
import com.music.Album;

/**
 * Created by rsverrisson on 25-06-2018.
 */
public class Library {
    private ArrayList<Album> library;


    public Library(String pathToLibrary) throws IOException {
        library = csvLibraryLoader.loadLibrary(pathToLibrary);
    }

    public Library(ArrayList<Album> library) {
        this.library = library;
    }

    public Library() {
        this.library = new ArrayList<Album>();
    }

    public void addAlbum(Album album) {
        library.add(album);
    }

    public Album getAlbum(int position) {
        return library.get(position);
    }

    public ArrayList<Album> getAlbums() {
        return library;
    }

    public void printLibrary() {
        for (Album album : library) {
            album.printAlbum();
        }
    }
}
