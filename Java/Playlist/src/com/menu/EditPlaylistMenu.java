package com.menu;

import com.player.Playlist;

import java.util.Scanner;
/**
 * Created by rsverrisson on 03-07-2018.
 */
public class EditPlaylistMenu extends BaseMenu {

    Playlist playlist;

    protected EditPlaylistMenu(Scanner scanner, Playlist playlist) {
        super(scanner);
        this.playlist = playlist;
        menuEntries = MenuEntry.getMenuFromCategory(MenuCategory.EDIT_PLAYLIST);
    }


    public void execute() {
        while (!MenuEntry.FINISH_EDIT.equals(selectedEntry)) {
            System.out.println("Select action: ");
            printMenu();
            getUserAction();
            playlist.performUserAction(selectedEntry);
        }
    }
}
