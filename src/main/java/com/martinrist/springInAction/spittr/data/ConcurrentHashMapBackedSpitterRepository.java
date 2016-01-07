package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spitter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementation of the SpitterRepository interface that is backed by a ConcurrentHashMap.
 * Keys in the map are the username, values are instances of the Spitter.
 */
@Repository
@Primary
public class ConcurrentHashMapBackedSpitterRepository implements SpitterRepository {

    private final Map<String, Spitter> repository = new ConcurrentHashMap<>();

    /**
     * Add a new Spitter instance into the repository with the key as
     * specified by the username.  Returns the Spitter originally provided.
     *
     * If the repository already contains an entry with the same username as
     * the supplied spitter argument, the entry is updated.
     *
     * @param spitter The spitter instance to be saved.
     * @return The original spitter instance.
     * @throws IllegalArgumentException if spitter has a null username.
     */
    @Override
    public Spitter save(Spitter spitter) {
        String username = spitter.getUsername();
        if (username == null) {
            throw new IllegalArgumentException("Unable to add Spitter with null username");
        }
        repository.put(spitter.getUsername(), spitter);
        return spitter;
    }

    /**
     * Retrieve a spitter instance from the repository by username.
     *
     * @param username The user name to be looked up.
     * @return The retrieved spitter, or null if no entry exists with the specified user name.
     */
    @Override
    public Spitter findByUserName(String username) {
        return repository.get(username);
    }

}
