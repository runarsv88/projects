package com.menu;

import com.player.Playlist;

import java.util.Scanner;

/**
 * Created by rsverrisson on 02-07-2018.
 */
public class PlaybackMenu extends BaseMenu {
    Playlist playlist;

    protected PlaybackMenu(Scanner scanner, Playlist playlist) {
        super(scanner);
        this.playlist = playlist;
        menuEntries = MenuEntry.getMenuFromCategory(MenuCategory.PLAYBACK);
    }

    @Override
    public void printMenu() {
        System.out.print("Current song is ");
        playlist.printCurrentSong();
        super.printMenu();
    }

    public void execute() {
        while (!MenuEntry.STOP.equals(selectedEntry)) {
            System.out.println("Select action: ");
            printMenu();
            getUserAction();
            playlist.performUserAction(selectedEntry);
        }
    }
}
