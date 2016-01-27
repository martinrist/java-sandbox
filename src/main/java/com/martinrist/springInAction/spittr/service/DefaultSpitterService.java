package com.martinrist.springInAction.spittr.service;

import com.martinrist.springInAction.spittr.data.SpitterRepository;
import com.martinrist.springInAction.spittr.data.SpittleRepository;
import com.martinrist.springInAction.spittr.domain.Spitter;
import com.martinrist.springInAction.spittr.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSpitterService implements SpitterService {

    @Autowired
    SpitterRepository spitterRepository;

    @Autowired
    SpittleRepository spittleRepository;

    @Override
    public List<Spittle> getRecentSpittles(int count) {
        return spittleRepository.findSpittles(Long.MAX_VALUE, count);
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        spittleRepository.save(spittle);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        spitterRepository.save(spitter);
    }

    @Override
    public Spitter getSpitter(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startFollowing(Spitter follower, Spitter followee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(String username) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spitter getSpitter(String username) {
        return spitterRepository.findByUserName(username);
    }

    @Override
    public Spittle getSpittleById(long id) {
        return spittleRepository.findSpittle(id);
    }

    @Override
    public void deleteSpittle(long id) {
        spittleRepository.remove(id);
    }

    @Override
    public List<Spitter> getAllSpitters() {
        throw new UnsupportedOperationException();
    }
}
