package com.martinrist.springInAction.chapter5.data;

import com.martinrist.springInAction.chapter5.domain.Spitter;
import org.springframework.stereotype.Repository;

/**
 * Dummy implementation of the SpitterRepository interface.  This implementation
 * doesn't do any saving, but instead just returns the Spitter it was given.
 *
 * Attempting to retrieve a spitter by username always succeeds, returning a
 * new Spitter instance with the specified username and dummy values for the other
 * properties.
 */
@Repository
public class DummySpitterRepository implements SpitterRepository {

    @Override
    public Spitter save(Spitter spitter) {
        return spitter;
    }

    @Override
    public Spitter findByUserName(String username) {
        return new Spitter(null, "dummyFirstName", "dummyLastName", username, "dummyPassword");
    }
    
}
