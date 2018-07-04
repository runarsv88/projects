package com.player;

import com.library.Library;
import com.menu.MenuEntry;
import com.music.Album;

import java.util.Scanner;

/**
 * Created by rsverrisson on 28-06-2018.
 */
public class PlaylistFactory {
    private Scanner scanner;
    private Library musicLibrary;

    public PlaylistFactory(Library musicLibrary, Scanner scanner) {
        this.scanner = scanner;
        this.musicLibrary = musicLibrary;
    }

    public Playlist create(String name) {
        return new Playlist(musicLibrary, scanner, name);
    }

    public Playlist createEverything() {
        Playlist pl = new Playlist(musicLibrary, scanner, "Everything");
        for (Album album : musicLibrary.getAlbums()) {
            for (int songNumb = 1; songNumb <= album.getTrackList().size(); songNumb++) {
                pl.addToPlaylist(album, songNumb);
            }
        }
        pl.performUserAction(MenuEntry.FINISH_EDIT);
        return pl;
    }
}
