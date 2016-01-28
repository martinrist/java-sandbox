package com.martinrist.springInAction.spittr.service;

import com.martinrist.springInAction.spittr.domain.Spitter;
import com.martinrist.springInAction.spittr.domain.Spittle;

import java.util.List;

public interface SpitterService {

    List<Spittle> getRecentSpittles(int count);
    Spittle saveSpittle(Spittle spittle);
    void saveSpitter(Spitter spitter);
    Spitter getSpitter(long id);
    void startFollowing(Spitter follower, Spitter followee);
    List<Spittle> getSpittlesForSpitter(Spitter spitter);
    List<Spittle> getSpittlesForSpitter(String username);
    Spitter getSpitter(String username);
    Spittle getSpittleById(long id);
    void deleteSpittle(long id);
    List<Spitter> getAllSpitters();

}
