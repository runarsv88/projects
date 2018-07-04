package com.menu;

import com.player.PlayerControls;
import com.player.Playlist;
import com.player.PlaylistFactory;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rsverrisson on 02-07-2018.
 */
public class TopLevelMenu extends BaseMenu implements PlayerControls {
    private ArrayList<Playlist> playlists;
    private PlaylistFactory playlistFactory;

    protected TopLevelMenu(Scanner scanner, ArrayList<Playlist> playlists, PlaylistFactory playlistFactory) {
        super(scanner);
        this.playlists = playlists;
        this.playlistFactory = playlistFactory;
        menuEntries = MenuEntry.getMenuFromCategory(MenuCategory.TOP_LEVEL);
    }

    public void execute() {
        System.out.println("Select action: ");
        printMenu();
        getUserAction();

        switch (selectedEntry){
            case PLAY_PLAYLIST:
                if (isPlaylistExist()) {
                    playPlaylist();
                }
                break;
            case EDIT_PLAYLIST:
                if (isPlaylistExist()) {
                    editPlaylist();
                }
                break;
            case CREATE_PLAYLIST:
                createPlaylist();
                break;
            case QUIT:
                break;
        }
    }

    private void printPlaylists() {
        int counter = 0;
        if (playlists.size() == 0) {
            System.out.println("You do not have any playlists.");
        } else {
            for (Playlist pl : playlists) {
                System.out.println(++counter + ". " + pl.getName());
            }
        }
    }

    private Playlist selectPlaylist() {
        System.out.println("Select playlist: ");
        printPlaylists();
        return playlists.get(scanner.nextInt()-1);
    }

    public void playPlaylist() {
        new PlaybackMenu(scanner, selectPlaylist()).execute();
    }

    public void createPlaylist(){
        System.out.println("Enter name for playlist: ");
        String name = scanner.next();
        Playlist pl = playlistFactory.create(name);
        playlists.add(pl);
        new EditPlaylistMenu(scanner, pl).execute();
    }

    public void editPlaylist() {
        new EditPlaylistMenu(scanner, selectPlaylist()).execute();
    }

    private Boolean isPlaylistExist() {
        if (playlists.size() == 0) {
            System.out.println("You have to create a playlist first...");
            return false;
        }
        return true;
    }

}
