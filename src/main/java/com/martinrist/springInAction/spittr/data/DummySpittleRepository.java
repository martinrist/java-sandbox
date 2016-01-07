package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spittle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DummySpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {

        List<Spittle> spittles = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            spittles.add(new Spittle((long)i, "Spittle " + i, new Date()));
        }
        return spittles;

    }

    @Override
    public Spittle findSpittle(long id) {
        return new Spittle(id, "Spittle " + id, new Date());
    }
}
