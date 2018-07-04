package com.player;

import com.library.Library;
import com.menu.MenuEntry;
import com.menu.MenuFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rsverrisson on 26-06-2018.
 */
public class Player {
    private ArrayList<Playlist> playlists;
    private Scanner scanner;
    private PlaylistFactory playlistFactory;
    private MenuFactory menuFactory;

    public Player(String pathToLibrary) throws IOException {
        playlists = new ArrayList<>();
        scanner = new Scanner(System.in);
        playlistFactory = new PlaylistFactory(new Library(pathToLibrary), scanner);
        menuFactory = new MenuFactory(scanner, playlists, playlistFactory);
        playlists.add(playlistFactory.createEverything());
    }

    public void start() {
        while (! MenuEntry.QUIT.equals(menuFactory.getTopLevelMenu().getSelectedEntry())) {
            menuFactory.getTopLevelMenu().execute();
        }
    }
}
