package com.n27.stats.function;

import com.n27.stats.model.Statistic;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests statistic reduces method.
 * Gives two statistic object as a parameter
 * and checks merged statistic object.
 */
public class StatisticReducerTest {

    Statistic st1;

    Statistic st2;

    @Before
    public void init() {

        st1 = new Statistic(10, 10, 10, 10, 1);

        st2 = new Statistic(15, 20, 25, 4, 3);

    }

    @Test
    public void reduceTest() {

        Statistic statistic = new StatisticReducer().apply(st1, st2);

        assert statistic.getSum() == 25;

        assert statistic.getAvg() == 15;

        assert statistic.getMax() == 25;

        assert statistic.getMin() == 4;

        assert statistic.getCount() == 4;

    }

}
