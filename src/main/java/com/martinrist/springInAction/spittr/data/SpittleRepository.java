package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spittle;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Interface for accessing a repository of Spittles data
 */
public interface SpittleRepository {

    @Cacheable("spittleCache")
    List<Spittle> findSpittles(long max, int count);

    @Cacheable("spittleCache")
    Spittle findSpittle(long id);

    @CachePut(value = "spittleCache", key = "#result.id")
    Spittle save(Spittle spittle);

    @CacheEvict("spittleCache")
    void remove(long spittleId);

}
