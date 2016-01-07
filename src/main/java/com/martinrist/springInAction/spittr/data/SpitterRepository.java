package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spitter;

/**
 * Interface for accessing a repository of Spitter data (the users who submit
 * Spittles).
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);
    Spitter findByUserName(String username);

}
