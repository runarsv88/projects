package com.player;

import com.library.Library;
import com.menu.MenuEntry;
import com.music.Album;

import java.util.*;

/**
 * Created by rsverrisson on 26-06-2018.
 */
public class Playlist implements Controls {
    private Library musicLibrary;
    private LinkedList<PlaylistEntry> playlist;
    private Scanner scanner;
    private String name;
    private ListIterator<PlaylistEntry> iterator;
    private Boolean playing = false;

    Playlist(Library library, Scanner scanner, String name) {
        this.musicLibrary = library;
        this.playlist = new LinkedList<>();
        this.scanner = scanner;
        this.name = name;
    }

    public void performUserAction(MenuEntry userAction) {
        switch (userAction) {
            case PLAY_PAUSE:
                playPause();
                break;
            case REPLAY:
                replay();
                break;
            case SKIP_TO_NEXT_TRACK:
                skipToNext();
                break;
            case SKIP_TO_PREVIOUS_TRACK:
                skipToPrevious();
                break;
            case REMOVE_FROM_PLAYLIST:
                removeCurrentFromPlaylist();
                break;
            case PRINT_PLAYLIST:
                printPlaylist();
                break;
            case STOP:
                break;
            case ADD_SONG_TO:
                addToPlaylist();
                break;
            case REMOVE_SONG_FROM:
                removeFromPlaylist();
                break;
            case FINISH_EDIT:
                iterator = playlist.listIterator();
                break;
        }
    }

    public void printPlaylist() {
        System.out.println("######## Playlist ###########");
        int counter = 0;
        for (PlaylistEntry pe : playlist) {
            System.out.print(++counter + ". ");
            pe.printEntry();
        }
        System.out.println("#############################");
    }

    public void addToPlaylist() {
        System.out.println("Select album: ");
        int counter = 0;
        for (Album album : musicLibrary.getAlbums()) {
            System.out.print(counter++ + ". ");
            album.printAlbumShort();
        }
        int albumNumber = scanner.nextInt();
        Album selectedAlbum = musicLibrary.getAlbum(albumNumber);
        System.out.println(String.format("Select song from %s by %s: ", selectedAlbum.getTitle(),
                selectedAlbum.getArtist()));
        selectedAlbum.printAlbum();
        int songNumber = scanner.nextInt();
        PlaylistEntry pe = new PlaylistEntry(selectedAlbum, songNumber);
        playlist.add(pe);

        System.out.println("Added to playlist...");
        pe.printEntry();
        printPlaylist();
    }

    public void addToPlaylist(Album album, int songNumber) {
        playlist.add(new PlaylistEntry(album, songNumber));
    }

    public void removeFromPlaylist() {
        int songNumber = scanner.nextInt();
        System.out.print("Removing from playlist: ");
        playlist.get(songNumber).printEntry();
        playlist.remove(songNumber);
    }

    public void printCurrentSong() {
        if ( iterator.hasNext() ) {
            iterator.next().printEntry();
            iterator.previous();
        } else {
            System.out.println("Reached end of playlist.");
        }
    }

    public void removeCurrentFromPlaylist() {
        if (iterator.hasNext()) {
            iterator.remove();
        } else {
            System.out.println("Reached end of playlist, nothing to remove.");
        }
    }

    private void playPause() {
        playing = !playing;
        if (playing) {
            playPlaylist();
        } else {
            System.out.println("Paused");
        }
    }

    public void playPlaylist() {
        if (iterator.hasNext()) {
            System.out.print("Playing: ");
            iterator.next().printEntry();
            iterator.previous();
        } else {
            System.out.println("Reached end of playlist.");
        }
    }

    public void skipToNext() {
        if (iterator.hasNext()){
            System.out.println("Skipping to next");
            iterator.next();
            if (playing) {
                playPlaylist();
            }
        } else {
            System.out.println("Reached end of playlist.");
        }
    }

    public void replay() {
        System.out.println("Replaying song");
    }

    public void skipToPrevious() {
        if (iterator.hasPrevious()) {
            System.out.println("Skipping to previous");
            iterator.previous();
            if (playing) {
                playPlaylist();
            }
        } else {
            System.out.println("You are already at the start of the playlist.");
        }
    }

    private class PlaylistEntry {
        private Album album;
        private int songNumber;

        public PlaylistEntry(Album album, int songNumber) {
            this.album = album;
            this.songNumber = songNumber;
        }

        public void printEntry() {
            System.out.println(album.getArtist() + " - " + album.getTitle() + " - "
                    + album.getTrackList().get(songNumber - 1).getTitle());
        }
    }

    public String getName(){
        return name;
    }
}
