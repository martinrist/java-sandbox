package com.martinrist.springInAction.chapter3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CounterConfig.class)
public class CounterTest {

    @Autowired
    private Counter counter1;

    @Autowired
    private Counter counter2;

    @Test
    public void testCountersAreDifferentObjects() {
        assertThat(counter1, not(sameInstance(counter2)));
    }

    @Test
    public void testCountersHaveDifferentIds() {
        assertThat(counter1.getId(), not(counter2.getId()));
    }


}
