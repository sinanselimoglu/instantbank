package com.n27.stats.function;

import com.n27.stats.model.Statistic;

import java.util.function.BinaryOperator;

/**
 * Gets two statistic object
 * and merge them considering
 * min, max , avg , count and sum info
 */
public class StatisticReducer implements BinaryOperator<Statistic> {

    public Statistic apply(Statistic statistic, Statistic statistic2) {

        double min = statistic.getMin() < statistic2.getMin() ?
                statistic.getMin() : statistic2.getMin();

        double max = statistic.getMax() > statistic2.getMax() ?
                statistic.getMax() : statistic2.getMax();


        double avg = (statistic.getAvg() + statistic2.getAvg()) / 2;

        double count = statistic.getCount() + statistic2.getCount();

        double sum = statistic.getSum() + statistic2.getSum();

        return new Statistic(sum, avg, max, min, count);
    }

}
