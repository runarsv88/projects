package com.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsverrisson on 26-06-2018.
 */
public enum MenuEntry {
    QUIT (MenuCategory.TOP_LEVEL, "Quit"),
    CREATE_PLAYLIST(MenuCategory.TOP_LEVEL, "Create a playlist"),
    EDIT_PLAYLIST(MenuCategory.TOP_LEVEL, "Add/remove songs from a playlist"),
    PLAY_PLAYLIST(MenuCategory.TOP_LEVEL, "Play playlists"),

    STOP (MenuCategory.PLAYBACK, "Stop"),
    PLAY_PAUSE (MenuCategory.PLAYBACK, "Play"),
    REPLAY(MenuCategory.PLAYBACK, "Replay track"),
    SKIP_TO_NEXT_TRACK (MenuCategory.PLAYBACK, "Skip to next track"),
    SKIP_TO_PREVIOUS_TRACK (MenuCategory.PLAYBACK, "Skip to previous track"),
    REMOVE_FROM_PLAYLIST (MenuCategory.PLAYBACK, "Remove from playlist"),
    PRINT_PLAYLIST(MenuCategory.PLAYBACK, "Print playlist"),

    ADD_SONG_TO(MenuCategory.EDIT_PLAYLIST, "Add song to playlist"),
    REMOVE_SONG_FROM(MenuCategory.EDIT_PLAYLIST, "Remove song from playlist"),
    FINISH_EDIT(MenuCategory.EDIT_PLAYLIST, "Finish");

    private String menuText;
    private MenuCategory menuCategory;

    MenuEntry(MenuCategory menuCategory, String menuText) {
        this.menuCategory = menuCategory;
        this.menuText = menuText;
    }

    private Boolean isCategory(MenuCategory category){
        return category.equals(menuCategory);
    }

    @Override
    public String toString(){
        return  menuText;
    }

    public static List<MenuEntry> getMenuFromCategory(MenuCategory category) {
        List<MenuEntry> entryList = new ArrayList<>();
        for (MenuEntry entry : MenuEntry.values()) {
            if (entry.isCategory(category)) {
               entryList.add(entry);
            }
        }
        return entryList;
    }


}
