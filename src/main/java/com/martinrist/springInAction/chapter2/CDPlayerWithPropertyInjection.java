package com.martinrist.springInAction.chapter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Example class to demonstrate use of property injection.
 */
@Component
public class CDPlayerWithPropertyInjection implements MediaPlayer {

    private CompactDisc compactDisc;

    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }

    public CompactDisc getCompactDisc() {
        return compactDisc;
    }
}
