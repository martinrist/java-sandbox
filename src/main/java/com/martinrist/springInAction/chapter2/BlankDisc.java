package com.martinrist.springInAction.chapter2;

import java.util.Collections;
import java.util.List;

/**
 * An implementation of CompactDisc whose album title and artist can be set
 * on construction.
 */

public class BlankDisc implements CompactDisc {

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artist) {
        this(title, artist, Collections.emptyList());
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }
}
