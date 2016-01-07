package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spittle;

import java.util.List;

/**
 * Interface for accessing a repository of Spittles data
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findSpittle(long id);
}
