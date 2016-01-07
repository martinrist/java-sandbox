package com.martinrist.springInAction.chapter5.data;

import com.martinrist.springInAction.chapter5.domain.Spittle;

import java.util.List;

/**
 * Interface for accessing a repository of Spittles data
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
