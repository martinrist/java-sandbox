package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spittle;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DummySpittleRepository implements SpittleRepository {

    static long SPITTLE_ID_COUNTER = 1000;

    private static final Logger LOGGER = Logger.getLogger(DummySpittleRepository.class);

    @Override
    public List<Spittle> findSpittles(long max, int count) {

        LOGGER.info(String.format("Finding %d Spittles up to ID %d", max, count));
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            spittles.add(new Spittle((long)i, "Spittle " + i, new Date()));
        }
        return spittles;

    }

    @Override
    public Spittle findSpittle(long id) {
        LOGGER.info(String.format("Finding Spittle with ID %d", id));
        return new Spittle(id, "Spittle " + id, new Date());
    }

    @Override
    public Spittle save(Spittle spittle) {
        Spittle result = new Spittle(SPITTLE_ID_COUNTER++, "Spittle " + SPITTLE_ID_COUNTER, new Date());
        return result;
    }

    @Override
    public void remove(long spittleId) {
        // Do nothing, as this is a dummy implementation
    }
}
