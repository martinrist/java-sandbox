package com.martinrist.springInAction.chapter2;

import org.springframework.stereotype.Component;

/**
 * A specific implementation of CompactDisc that represents the album
 * 'Sergeant Pepper's Lonely Hearts Club Band'.
 */

@Component
public class SgtPeppers implements CompactDisc {

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
