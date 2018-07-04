package com.menu;

import com.player.Playlist;
import com.player.PlaylistFactory;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rsverrisson on 02-07-2018.
 */
public class MenuFactory {
    private TopLevelMenu topLevelMenu;

    private Scanner scanner;
    private ArrayList<Playlist> playlists;
    private PlaylistFactory playlistFactory;

    public MenuFactory(Scanner scanner, ArrayList<Playlist> playlists, PlaylistFactory playlistFactory) {
        this.scanner = scanner;
        this.playlists = playlists;
        this.playlistFactory = playlistFactory;
    }
    public TopLevelMenu getTopLevelMenu() {
        if (topLevelMenu == null) {
            topLevelMenu = new TopLevelMenu(scanner, playlists, playlistFactory);
        }
        return topLevelMenu;
    }

}
