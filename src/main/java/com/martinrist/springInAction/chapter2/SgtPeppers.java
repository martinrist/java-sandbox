package com.martinrist.springInAction.chapter2;

import org.springframework.stereotype.Component;

/**
 * A specific implementation of CompactDisc that represents the album
 * 'Sergeant Pepper's Lonely Hearts Club Band'.
 */

@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
