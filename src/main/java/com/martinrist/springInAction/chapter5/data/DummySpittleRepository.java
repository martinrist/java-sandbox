package com.martinrist.springInAction.chapter5.data;

import com.martinrist.springInAction.chapter5.domain.Spittle;
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
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;

    }
}
