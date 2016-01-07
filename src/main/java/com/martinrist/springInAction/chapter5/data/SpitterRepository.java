package com.martinrist.springInAction.chapter5.data;

import com.martinrist.springInAction.chapter5.domain.Spitter;

/**
 * Interface for accessing a repository of Spitter data (the users who submit
 * Spittles).
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);
    Spitter findByUserName(String username);

}
