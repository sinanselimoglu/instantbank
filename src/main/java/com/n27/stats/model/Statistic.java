package com.n27.stats.model;


public class Statistic {

    private double sum;

    private double avg;

    private double max;

    private double min;

    private double count;

    public Statistic() {
    }

    public Statistic(double sum, double avg, double max, double min, double count) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "sum=" + sum +
                ", avg=" + avg +
                ", max=" + max +
                ", min=" + min +
                ", count=" + count +
                '}';
    }
}
